import java.util.concurrent.*;
import javax.swing.JTextArea;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.platform.win32.WinUser.*;

public class Win32EventDetector implements WindowProc, Runnable {


/** FIXME: don't know if this number is a real message ID. */
private static final int DESTROY_LISTENER = 4242; 

volatile boolean closed = true;
Semaphore closing = new Semaphore(0);
WString windowClass;
HMODULE hInst;
HWND hWnd;
JTextArea detectMsgs;

public void setMsgLogger(JTextArea detectMsgs) {
    this.detectMsgs = detectMsgs;
}

void println(String msg) {

    if (detectMsgs == null) {
        System.out.println(msg);
    } else {
        detectMsgs.append('\n' + msg);
        detectMsgs.setCaretPosition(detectMsgs.getDocument().getLength());
    }
}

@Override
public void run() {

    // define new window class
    windowClass = new WString("Win32EventDetectorClass");
    hInst = Kernel32.INSTANCE.GetModuleHandle("");
    WNDCLASSEX wClass = new WNDCLASSEX();
    wClass.hInstance = hInst;
    wClass.lpfnWndProc = Win32EventDetector.this;
    wClass.lpszClassName = windowClass;
    // register window class
    User32.INSTANCE.RegisterClassEx(wClass);
    getLastError();
    // create new window
    hWnd = User32.INSTANCE
            .CreateWindowEx(
                    User32.WS_EX_TOPMOST,
                    windowClass,
                    "My hidden helper window, used only to catch the windows events",
                    0, 0, 0, 0, 0,
                    null, // WM_DEVICECHANGE contradicts parent=WinUser.HWND_MESSAGE
                    null, hInst, null);
    getLastError();
    println("window sucessfully created! window hwnd: "
            + hWnd.getPointer().toString());

    closed = false;
    Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() { close(); }
    });

    Wtsapi32.INSTANCE.WTSRegisterSessionNotification(hWnd,
            Wtsapi32.NOTIFY_FOR_THIS_SESSION);
    println("Listening for window messages.");
    try {
        MSG msg = new MSG();
        while (User32.INSTANCE.GetMessage(msg, hWnd, 0, 0) != 0) {
            if (msg.message == DESTROY_LISTENER) {
                System.out.println("Got destroy message.");
                break;
            }
            println("Got a new message: " + msg.message);
            User32.INSTANCE.TranslateMessage(msg);
            User32.INSTANCE.DispatchMessage(msg);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("Stopped listening for window messages.");
    destroy();
}

private void destroy() {

    try {
        Wtsapi32.INSTANCE.WTSUnRegisterSessionNotification(hWnd);
        User32.INSTANCE.UnregisterClass(windowClass, hInst);
        User32.INSTANCE.DestroyWindow(hWnd);
        System.out.println("Hidden native window destroyed.");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        closed = true;
        closing.release();
    }
}

public void close() {

    if (closed) { return; }
    User32.INSTANCE.PostMessage(hWnd, DESTROY_LISTENER, null, null);
    try {
        if (closing.tryAcquire(1000L, TimeUnit.MILLISECONDS)) {
            System.out.println("Hidden native window closed.");
        } else {
            System.out.println("Hidden native window could not be closed within time-out.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public LRESULT callback(HWND hwnd, int uMsg, WPARAM wParam, LPARAM lParam) {
    switch (uMsg) {
    case WinUser.WM_CREATE: {
        println("onCreate: WM_CREATE");
        return new LRESULT(0);
    }
    case WinUser.WM_DESTROY: {
        User32.INSTANCE.PostQuitMessage(0);
        return new LRESULT(0);
    }
    case WinUser.WM_SESSION_CHANGE: {
        this.onSessionChange(wParam, lParam);
        return new LRESULT(0);
    }
    default:
        return User32.INSTANCE.DefWindowProc(hwnd, uMsg, wParam, lParam);
    }
}

public int getLastError() {
    int rc = Kernel32.INSTANCE.GetLastError();
    if (rc != 0)
        println("error: " + rc);
    return rc;
}

protected void onSessionChange(WPARAM wParam, LPARAM lParam) {
    switch (wParam.intValue()) {
    case Wtsapi32.WTS_CONSOLE_CONNECT: {
        println("WTS_CONSOLE_CONNECT");
        break;
    }
    case Wtsapi32.WTS_CONSOLE_DISCONNECT: {
        println("WTS_CONSOLE_DISCONNECT");
        break;
    }
    case Wtsapi32.WTS_SESSION_LOGON: {
        println("WTS_SESSION_LOGON");
        break;
    }
    case Wtsapi32.WTS_SESSION_LOGOFF: {
        println("WTS_SESSION_LOGOFF");
        break;
    }
    case Wtsapi32.WTS_SESSION_LOCK: {
        println("WTS_SESSION_LOCK");
        break;
    }
    case Wtsapi32.WTS_SESSION_UNLOCK: {
        println("WTS_SESSION_UNLOCK");
        break;
    }
    default: 
        println("Session change " + wParam.intValue());
        break;
    }
}

}
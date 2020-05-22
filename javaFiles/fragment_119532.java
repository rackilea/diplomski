import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.examples.win32.W32API.HWND;
import com.sun.jna.examples.win32.W32API.LPARAM;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;


public class IterateChildWindows {
    public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

        HWND FindWindow(String lpClassName, String lpWindowName);
        int GetWindowRect(HWND handle, int[] rect);
        int SendMessage(HWND hWnd, int msg, int wParam, byte[] lParam); 
        HWND FindWindowEx(HWND parent, HWND child, String className, String window);

        boolean EnumWindows(WNDENUMPROC lpEnumFunc, Pointer arg);
        boolean EnumChildWindows(HWND parent, WNDENUMPROC callback, LPARAM info);

        interface WNDENUMPROC extends StdCallCallback {
            boolean callback(HWND hWnd, Pointer arg);
        }

        int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
        long GetWindowLong(HWND hWnd, int index);
        boolean SetForegroundWindow(HWND in);
        int GetClassNameA(HWND in, byte[] lpString, int size);
    }

    public static void main(String[] args) {        
        User32.INSTANCE.EnumWindows(new User32.WNDENUMPROC() {
            public boolean callback(HWND hWnd, Pointer userData) { // this will be called for each parent window found by EnumWindows(). the hWnd parameter is the HWND of the window that was found.
                byte[] textBuffer = new byte[512];
                User32.INSTANCE.GetWindowTextA(hWnd, textBuffer, 512);
                String wText = Native.toString(textBuffer);
                System.out.println("Window found: " + wText);

                // now call EnumChildWindows() giving the previously found parent window as the first parameter
                User32.INSTANCE.EnumChildWindows(hWnd, new User32.WNDENUMPROC() {
                    public boolean callback(HWND hWnd, Pointer userData) { // this is called for each child window that EnumChildWindows() finds - just like before with EnumWindows().
                        byte[] textBuffer = new byte[512];
                        User32.INSTANCE.GetClassNameA(hWnd, textBuffer, 512);
                        System.out.println(" - Found sub window / control class: " + new String(textBuffer).trim());
                        return true;
                    }
                }, null);
                return true;
            }
        }, null);
    }
}
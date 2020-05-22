package jnatest;

import jnatest.WinUserX.LowLevelMouseProc;
import jnatest.WinUserX.MSLLHOOKSTRUCT;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.MSG;

public class MouseHook
{
    private static volatile boolean quit;
    private static HHOOK hhk;
    private static LowLevelMouseProc mouseHook;

    public static void main(String[] args) 
    {
        System.out.println("Press middle button to quit.");
        final User32 lib = User32.INSTANCE;
        HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        mouseHook = new LowLevelMouseProc() 
        {
            public LRESULT callback(int nCode, WPARAM wParam, MSLLHOOKSTRUCT info) 
            {
                if (nCode >= 0) 
                {
                    switch (wParam.intValue())
                    {
                        case WinUserX.WM_LBUTTONDOWN:
                            System.out.println("Left button click at " + info.pt.x + ", " + info.pt.y);
                            break;
                        case WinUserX.WM_LBUTTONUP:
                            System.out.println("Left button release.");
                            break;
                        case WinUserX.WM_MBUTTONDOWN:
                            System.out.println("Middle button.");
                            quit = true;
                            break;
                    }
                }
                return lib.CallNextHookEx(hhk, nCode, wParam, info.getPointer());
            }
        };
        hhk = lib.SetWindowsHookEx(WinUser.WH_MOUSE_LL, mouseHook, hMod, 0);
        new Thread() 
        {
            public void run() 
            {
                while (!quit) 
                {
                    try { Thread.sleep(10); } catch(InterruptedException e) { }
                }
                System.err.println("unhook and exit");
                lib.UnhookWindowsHookEx(hhk);
                System.exit(0);
            }
        }.start();

        // This bit never returns from GetMessage
        int result;
        MSG msg = new MSG();
        while ((result = lib.GetMessage(msg, null, 0, 0)) != 0) 
        {
            if (result == -1) 
            {
                System.err.println("error in get message");
                break;
            }
            else 
            {
                System.err.println("got message");
                lib.TranslateMessage(msg);
                lib.DispatchMessage(msg);
            }
        }
        lib.UnhookWindowsHookEx(hhk);
    }
}
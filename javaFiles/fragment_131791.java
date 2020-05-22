package jnatest;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;

public interface WinUserX extends WinUser
{
    public int WM_LBUTTONDOWN = 0x0201;
    public int WM_LBUTTONUP = 0x0202; 
    public int WM_MOUSEMOVE = 0x0200;
    public int WM_MOUSEWHEEL = 0x020A;
    public int WM_MOUSEHWHEEL = 0x020E;
    public int WM_RBUTTONDOWN = 0x0204;
    public int WM_RBUTTONUP = 0x0205;
    public int WM_MBUTTONDOWN = 0x0207;

    public interface LowLevelMouseProc extends HOOKPROC 
    {
        LRESULT callback(int nCode, WPARAM wParam, MSLLHOOKSTRUCT lParam);
    }

    public class MSLLHOOKSTRUCT extends Structure 
    {
        public POINT pt;
        public int mouseData;
        public int flags;
        public int time;
        public ULONG_PTR dwExtraInfo;
    }
}
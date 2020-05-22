import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.win32.StdCallLibrary;

public class GetTextInNotePad {
   public static final String NOTEPAD_CLASS = "Notepad";
   public static final String EDIT_CLASS = "Edit";

   interface User32 extends StdCallLibrary {
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      int WM_SETTEXT = 0x000c;
      int WM_GETTEXT = 0x000D;

      HWND FindWindowA(String lpClassName, String lpWindowName);
      HWND FindWindowExA(HWND hwndParent, HWND hwndChildAfter, String lpClassName,
            String lpWindowName);
      LRESULT SendMessageA(HWND paramHWND, int paramInt, WPARAM paramWPARAM, LPARAM paramLPARAM);
      LRESULT SendMessageA(HWND editHwnd, int wmGettext, long l, byte[] lParamStr);
      int GetClassNameA(HWND hWnd, byte[] lpString, int maxCount);
   }

   public static void main(String[] args) {
      User32 user32 = User32.INSTANCE;
      String lpClassName = "Notepad";
      HWND notePadHwnd = user32.FindWindowA(lpClassName , null);
      HWND editHwnd = user32.FindWindowExA(notePadHwnd, null, EDIT_CLASS, null); 
      byte[] lParamStr = new byte[512];
      LRESULT resultBool = user32.SendMessageA(editHwnd, User32.WM_GETTEXT, 512, lParamStr);

      System.out.println("lParamStr: " + Native.toString(lParamStr));
   }
}
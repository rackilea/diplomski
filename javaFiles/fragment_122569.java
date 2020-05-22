import com.sun.jna.*;
import com.sun.jna.platform.win32.ShellAPI;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.*;

public class Main {
    public interface Shell32 extends ShellAPI, StdCallLibrary {
        Shell32 INSTANCE = (Shell32)Native.loadLibrary("shell32", Shell32.class);

        WinDef.HINSTANCE ShellExecuteA(WinDef.HWND hwnd,
                                      String lpOperation,
                                      String lpFile,
                                      String lpParameters,
                                      String lpDirectory,
                                      int nShowCmd);
    }

    public static void main(String[] args) {
        WinDef.HWND h = null;
        Shell32.INSTANCE.ShellExecuteA(h, "runas", "cmd.exe", "/S /C \"netsh interface ip set address name=\"Wi-Fi\" static 192.168.88.189 255.255.255.0 192.168.88.1 1\"", null, 1);
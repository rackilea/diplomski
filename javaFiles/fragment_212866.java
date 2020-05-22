import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.win32.W32APIOptions;

public class ProcessList {

    public static void main(String[] args) {
        WinNT winNT = (WinNT) Native.loadLibrary(WinNT.class, W32APIOptions.UNICODE_OPTIONS);

        WinNT.HANDLE snapshot = winNT.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));

        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();

        while (winNT.Process32Next(snapshot, processEntry)) {
            //see if your process is open and update your counter
        }

        winNT.CloseHandle(snapshot);
    }
}
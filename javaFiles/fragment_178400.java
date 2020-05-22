import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary {

    public boolean GetVolumePathNamesForVolumeNameW(
              WString lpszVolumeName,
              char[] lpszVolumePathNames,
              DWORD cchBufferLength,
              IntByReference lpcchReturnLength
            );

    public int GetLastError();
}
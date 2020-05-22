import java.util.Arrays;

import com.sun.jna.Native;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.ptr.IntByReference;

public class TestJNA {

    static Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32.dll", Kernel32.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            System.out.println(getPathNames());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String getPathNames() throws Win32Exception {
        DWORD value = new DWORD(100);
        char[] pathNames = new char[100];
        IntByReference len = new IntByReference();
        if (kernel32.GetVolumePathNamesForVolumeNameW(getGuidPath(), pathNames, value, len)) {
            if (kernel32.GetLastError() == WindowsConstants.ERROR_MORE_DATA) {
                pathNames = new char[len.getValue()];
                DWORD sz = new DWORD(len.getValue());
                if (!kernel32.GetVolumePathNamesForVolumeNameW(getGuidPath(), pathNames, sz, len)) {
                    throw new Win32Exception(kernel32.GetLastError());
                }
            }
            else
                throw new Win32Exception(kernel32.GetLastError());
        }

        return Arrays.toString(pathNames);
    }

    private static WString getGuidPath() {

        final WString str  = new WString("\\\\?\\Volume{5b57f944-8d60-11de-8b2a-806d6172696f}\\");

        return str;
    }
}
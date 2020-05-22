/**
 * Definitions of the Win32 API. JNA has some for windows, so check first
 * In case CreateMutex is not included.
 */
public interface Kernel32Ex extends Kernel32 {
    WinNT.HANDLE CreateMutex(
            WinBase.SECURITY_ATTRIBUTES lpMutexAttributes,
            boolean bInitialOwner,
            String lpName
    );

    boolean ReleaseMutex(
            WinNT.HANDLE hMutex
    );
}

public static void main(String[] args) throws Exception {
    // The binding. Create it once
    final Kernel32Ex Win32 = Native.loadLibrary("kernel32", Kernel32Ex.class, W32APIOptions.UNICODE_OPTIONS);

    WinNT.HANDLE handle = Win32.CreateMutex(null,
            true,
            "My-Mutext");
    if (handle == null) {
        throw new Win32Exception(Win32.GetLastError());
    } else {
        System.out.println("Holding the win32 mutex");
        Win32.ReleaseMutex(handle);
    }
}
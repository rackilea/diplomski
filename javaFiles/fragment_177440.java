static class Kernel32 {
    static { Native.register("kernel32"); }
    public static int PROCESS_QUERY_INFORMATION = 0x0400;
    public static int PROCESS_VM_READ = 0x0010;
    public static native int GetLastError();
    public static native Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, Pointer pointer);
    public static native boolean GetProcessTimes(Pointer hProcess, int lpCreationTime,int LPFILETIME lpExitTime, int lpKernelTime, int lpUserTime
}

static class Psapi {
    static { Native.register("psapi"); }
    public static native int GetModuleBaseNameW(Pointer hProcess, Pointer hmodule, char[] lpBaseName, int size);
    ...
}

static class User32DLL {
    static { Native.register("user32"); }
    public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);
    public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
}

PointerByReference pointer = new PointerByReference();
GetWindowThreadProcessId(yourHandle, pointer);
Pointer process = OpenProcess(PROCESS_QUERY_INFORMATION | PROCESS_VM_READ, false, pointer.getValue());
GetModuleBaseNameW(process, null, buffer, MAX_TITLE_LENGTH);
System.out.println("Active window process: " + Native.toString(buffer));
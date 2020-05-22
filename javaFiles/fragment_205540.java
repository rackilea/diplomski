public interface Kernel32MissingFunctions extends StdCallLibrary {

    Kernel32MissingFunctions INSTANCE = (Kernel32MissingFunctions) Native.loadLibrary("kernel32",
            Kernel32MissingFunctions.class, W32APIOptions.ASCII_OPTIONS);

    public static final int MEM_RELEASE = 0x8000;

    public LPVOID VirtualAllocEx(HANDLE hProcess, LPVOID lpAddress, long dwSize, int flAllocationType, int flProtect);

    public int VirtualFreeEx(HANDLE hProcess, LPVOID lpAddress, long dwSize, int dwFreeType);

    public LPVOID GetProcAddress(HMODULE hModule, String lpProcName);
}
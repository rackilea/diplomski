public static void main(String... args)
{
    int pid = getProcessId("Solitaire");
    Pointer process = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, pid);
}

public static int getProcessId(String window) {
     IntByReference pid = new IntByReference(0);
     user32.GetWindowThreadProcessId(user32.FindWindowA(null, window), pid);

     return pid.getValue();
}

public static Pointer openProcess(int permissions, int pid) {
     Pointer process = kernel32.OpenProcess(permissions, true, pid);
     return process;
}
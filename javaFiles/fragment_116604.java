public static void main(String... args)
{
    int pid = getProcessId("Solitaire");
    Pointer process = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, pid);

    long dynAddress = findDynAddress(process,offsets,baseAddress);

    Memory scoreMem = readMemory(process,dynAddress,4);
    int score = scoreMem.getInt(0);
    System.out.println(score);
}

public static Memory readMemory(Pointer process, long address, int bytesToRead) {
    IntByReference read = new IntByReference(0);
    Memory output = new Memory(bytesToRead);

    kernel32.ReadProcessMemory(process, address, output, bytesToRead, read);
    return output;
}
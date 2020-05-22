public static void main(String... args)
{
    int pid = getProcessId("Solitaire");
    Pointer process = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, pid);

    long dynAddress = findDynAddress(process,offsets,baseAddress);

    Memory scoreMem = readMemory(process,dynAddress,4);
    int score = scoreMem.getInt(0);
    System.out.println(score);

    byte[] newScore = new byte[]{0x22,0x22,0x22,0x22};
    writeMemory(process, dynAddress, newScore);
}

public static void writeMemory(Pointer process, long address, byte[] data)
{
    int size = data.length;
    Memory toWrite = new Memory(size);

    for(int i = 0; i < size; i++)
    {
            toWrite.setByte(i, data[i]);
    }

    boolean b = kernel32.WriteProcessMemory(process, address, toWrite, size, null);
}
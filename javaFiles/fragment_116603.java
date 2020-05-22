public static void main(String... args)
{
    int pid = getProcessId("Solitaire");
    Pointer process = openProcess(PROCESS_VM_READ|PROCESS_VM_WRITE|PROCESS_VM_OPERATION, pid);

    long dynAddress = findDynAddress(process,offsets,baseAddress);
}

public static long findDynAddress(Pointer process, int[] offsets, long baseAddress)
{

    long pointer = baseAddress;

    int size = 4;
    Memory pTemp = new Memory(size);
    long pointerAddress = 0;

    for(int i = 0; i < offsets.length; i++)
    {
        if(i == 0)
        {
             kernel32.ReadProcessMemory(process, pointer, pTemp, size, null);
        }

        pointerAddress = ((pTemp.getInt(0)+offsets[i]));

        if(i != offsets.length-1)
             kernel32.ReadProcessMemory(process, pointerAddress, pTemp, size, null);


    }

    return pointerAddress;
}
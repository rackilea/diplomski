public static int decodeIntFromArray(byte[] array, int pos)
{
    return (int)
            (
                    ((array[pos+0] & 0xFF) << 24) 
                +   ((array[pos+1] & 0xFF) << 16)                 
                +   ((array[pos+2] & 0xFF) << 8) 
                +   ((array[pos+3] & 0xFF)
            );        
}
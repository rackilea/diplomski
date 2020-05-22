// Little endian int -> bytes
public static void GetBytes(int value,byte[] result,int offset){
    result[offset]=(byte)value;
    result[offset+1]=(byte) (value>>8);
    result[offset+2]=(byte) (value>>16);
    result[offset+3]=(byte) (value>>24);
}

// Little endian bytes -> int
public static int ToInt32(byte[] data,int offset){
    return    ( (int) data[offset] ) | 
            ( ( (int) data[offset+1] ) << 8 ) | 
            ( ( (int) data[offset+2] ) << 16 ) | 
            ( ( (int) data[offset+3] ) << 24 );
}
byte[] convertTo3ByteArray(short s){

   byte[] ret = new byte[3];
   ret[2] = (byte)(s & 0xff);
   ret[1] = (byte)((s >> 8) & 0xff);
   ret[0] = (byte)(0x00);

   return ret;

}

short convertToShort(byte[] arr){

    if(arr.length<2){
        throw new IllegalArgumentException("The length of the byte array is less than 2!");
    }

    return (short) ((arr[arr.length-1] & 0xff) + ((arr[arr.length-2] & 0xff ) << 8));       
}
byte[] bytes = new byte[10];
Byte[] byteObjects = new Byte[bytes.length];

int i=0;    
// Associating Byte array values with bytes. (byte[] to Byte[])
for(byte b: bytes)
   byteObjects[i++] = b;  // Autoboxing.

....

int j=0;
// Unboxing Byte values. (Byte[] to byte[])
for(Byte b: byteObjects)
    bytes[j++] = b.byteValue();
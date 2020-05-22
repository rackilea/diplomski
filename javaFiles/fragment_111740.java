byte[] bytes = new byte[] { (byte) 0x7d,  (byte) 0x44,  
               (byte)0x2d,  (byte)0x05,  (byte) 0x0e,  (byte)0x01,  
               (byte)0x11,  (byte)0x10,  (byte)0x2f,  (byte) 0x03,  
               (byte)0x00,  (byte)0x48};


for (int i=0; i<bytes.length; i++) {
    Byte b = bytes[i];
    if (b == 0x00) bytes[i] = 0x30;
}

try 
{
    String myString = new String(bytes, "US-ASCII").trim();
} 
catch (UnsupportedEncodingException e) 
{
    e.printStackTrace();
}
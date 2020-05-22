byte[] quoteutf8 = {(byte)0xE2, (byte)0x80, (byte)0x9D};
String decodedPlatformDefault = new String(quoteutf8, "Windows-1252");
byte[] encodedPlatformDefault = decodedPlatformDefault.getBytes("Windows-1252");

for( byte i : encodedPlatformDefault ) {
    System.out.print(String.format( "%02x ", i ));
   //e2 80 3f   
}
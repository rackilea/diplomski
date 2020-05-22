String ipAddress = "192.168.1.1";
String[] ipAddressParts = ipAddress.split("\\.");

// convert int string to byte values
Byte[] ipAddressBytes = new Byte[4];
for(int i=0; i<4; i++){
    Integer integer = Integer.parseInt(ipAddressParts[i]);
    ipAddressBytes[i] = integer.byteValue();
}
String macAddress = "AA:BB:CC:DD:EE:FF";
String[] macAddressParts = macAddress.split(":");

// convert hex string to byte values
Byte[] macAddressBytes = new Byte[6];
for(int i=0; i<6; i++){
    Integer hex = Integer.parseInt(macAddressParts[i], 16);
    macAddressBytes[i] = hex.byteValue();
}
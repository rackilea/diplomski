public byte[] testMethod(byte location, byte[] data)
{
    byte[] response = new byte[3 + data.length];
    response[0] = (byte) 0x00;
    response[1] = (byte) 0x21;
    response[2] = location;
    for (int i = 0; i < data.length; i++) {
        response[3 + i] = data[i];
    }
    return response;
}
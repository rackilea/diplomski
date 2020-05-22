private static byte[] addPKCS7Padding(byte[] data, int size) {
    byte pad = (byte)(size - (data.length % size));
    byte[] output = new byte[data.length + pad];
    System.arraycopy(data, 0, output, 0, data.length);
    for (int i = data.length; i < output.length; i++)
        output[i] = (byte)pad;
    return output;
}
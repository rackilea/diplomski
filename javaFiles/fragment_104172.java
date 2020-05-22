private static byte[] removePKCS7Padding(byte[] data, int size) {
    byte pad = data[data.length - 1];
    byte[] output = new byte[data.length - pad];
    System.arraycopy(data, 0, output, 0, data.length - pad);
    return output;      
}
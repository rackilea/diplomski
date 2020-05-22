if (uartDevice != null) {
    // Loop until there is no more data in the RX buffer.
    try {
        byte[] buffer = new byte[CHUNK_SIZE];
        int read;
        while ((read = uartDevice.read(buffer, buffer.length)) > 0) {
            for (int i = 0; i < read; i++) {
                System.out.printf("%02x", buffer[i]);
            }
        }
    } catch (IOException e) {
        Log.w(TAG, "Unable to transfer data over UART", e);
    }
    System.out.println();  // Adds a newline after all bytes
}
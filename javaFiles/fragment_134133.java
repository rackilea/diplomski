byte[] readFromDevice(UartDevice uartDevice) {
    byte[] buffer = new byte[CHUNK_SIZE];
    int read;
    ByteArrayOutputStream data = new ByteArrayOutputStream();

    while ((read = uartDevice.read(buffer, buffer.length)) > 0) {
        data.write(buffer, 0, read);
    }

    return data.toByteArray();
}
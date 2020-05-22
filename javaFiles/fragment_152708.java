public static byte[] wrapMessage (byte command, byte[] parameters) throws Exception {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    stream.write((byte) 0x90);
    stream.write(command);
    stream.write((byte) 0x00);
    stream.write((byte) 0x00);
    if (parameters != null) {
        stream.write((byte) parameters.length);
        stream.write(parameters);
    }
    stream.write((byte) 0x00);

    return stream.toByteArray();
}
public static byte[] objToByte(TcpPacket tcpPacket) throws IOException {
    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
    objStream.writeObject(tcpPacket);

    return byteStream.toByteArray();
}

public static Object byteToObj(byte[] bytes) throws IOException, ClassNotFoundException {
    ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
    ObjectInputStream objStream = new ObjectInputStream(byteStream);

    return objStream.readObject();
}
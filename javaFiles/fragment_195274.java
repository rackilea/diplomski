public static void write(DataOutputStream out, byte[] bytes) {
    out.writeInt(bytes.length());
    out.write(bytes);
}

public static byte[] read(DataInputStream in) {
    int length = in.readInt();
    byte[] bytes = new byte[length];
    in.readFully(bytes);
    return bytes;
}
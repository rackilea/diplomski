public static int read2BytesInt(InputStream in, int offset) throws IOException {

    byte[] b2 = new byte[2];
    in.skip(offset);
    in.read(b2);

    return (b2[0] << 8) + (b2[1] << 0);
}
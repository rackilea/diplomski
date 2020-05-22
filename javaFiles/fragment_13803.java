public void writeLong(OutputStream os, long l) throws IOException {
    os.write((byte) (l >> 56));
    os.write((byte) (l >> 48));
    os.write((byte) (l >> 40));
    os.write((byte) (l >> 32));
    os.write((byte) (l >> 24));
    os.write((byte) (l >> 16));
    os.write((byte) (l >> 8));
    os.write((byte) l);
}
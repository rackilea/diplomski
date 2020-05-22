public void removeBytesFromStart2(ByteBuffer bf, int n) {
    int index = 0;
    for(int i = n; i < bf.limit(); i++) {
        bf.put(index++, bf.get(i));
        bf.put(i, (byte)0);
    }
    bf.position(bf.position()-n);
}
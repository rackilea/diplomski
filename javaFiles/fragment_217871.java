private DirectByteBuffer(long addr, int cap) {
    super(-1, 0, cap, cap);
    address = addr;
    cleaner = null;
    att = null;
}
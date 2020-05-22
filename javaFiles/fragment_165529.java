static BitSet set;

static int pos(int i, int j, int k, int m) {
    return ((256*256*256) * i) + ((256*256) * j) + (256 * k) + m;
}

static boolean get(byte[] addr) {
    return set.get(pos(addr[0], addr[1], addr[2], addr[3]));
}

static void set(byte[] addr, boolean flag) {
    set.set(pos(addr[0], addr[1], addr[2], addr[3]), flag);
}
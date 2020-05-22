static final BitSet flags = new BitSet(7);

static void enableFlag(int i) {
    flags.set(i);
}

static void disableFlag(int i) {
    flags.set(i, false);
} 

static boolean checkFlag(int i) {
    return flags.get(i);
}
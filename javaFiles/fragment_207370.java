public static int bitsSet(char arg) {
    int counter = 0;
    for (int oneBit = 1; oneBit <= 0x8000; oneBit <<= 1) {
        if ((arg & oneBit) > 0) {
            counter++;
        }
    }
    return counter;
}
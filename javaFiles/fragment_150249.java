int value = 0b1101;
for (int i = 0; i < Integer.SIZE; i++) {
    if (((value << i) & 1) == 1) {
        // turn on
    } else {
        // turn off
    }
}
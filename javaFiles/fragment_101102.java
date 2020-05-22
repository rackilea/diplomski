byte output = 0;
for (int i = 0; i < 8; i++) {
    if (bits.get(i)) {
        output |= 1 << (7 - i);
    }
}
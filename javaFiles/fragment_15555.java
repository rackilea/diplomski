int b = bytes[i] & 0xFF;

for (int j = 7; j >= 0; j--) {
    int bit = (b >> j) & 1;

    temp = /* ... */;

    if (temp != 0) {
        b |= (1 << j);  // set bit j
    } else {
        b &= ~(1 << j); // clear bit j
    }
}

modified[i] = (byte) b;
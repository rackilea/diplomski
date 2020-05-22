for (int k = 1; k <= d; k++) {
    int diff = (1 << k) - 1;
    while (diff <= 0xFFFFFF) {
        if (hashes[key ^ diff])
            // do something with it
        diff = nextBitPermutation(diff);
    }
}
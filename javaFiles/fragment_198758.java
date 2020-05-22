public BigInt mul(BigInt o) {
    int max = n.length > o.n.length ? n.length : o.n.length;
    int[] newdigits = new int[n.length + o.n.length];

    for (int i = 0; i < max; i++) {
        for (int i2 = 0; i2 < max; i2++) {
            int digit1 = i >= n.length ? 0 : n[i];
            int digit2 = i2 >= o.n.length ? 0 : o.n[i2];
            if (digit1 > 0 && digit2 > 0) {
                int value = digit1 * digit2;
                int pos = i + i2;
                while (value > 0) {
                    int newDigit = (newdigits[pos] + value) % 10;
                    value = (newdigits[pos] + value) / 10;
                    newdigits[pos] = newDigit;
                    pos++;
                }
            }
        }
    }

    return new BigInt(newdigits);
}
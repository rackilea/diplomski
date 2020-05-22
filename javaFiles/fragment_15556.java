byte b = bytes[i];

BitSet bits = BitSet.valueOf(new byte[] { b });
for (int j = 7; j >= 0; j--) {
    int bit = bits.get(j) ? 1 : 0;

    temp = /* ... */;

    bits.set(j, temp != 0);
}

modified[i] = bits.toByteArray()[0];
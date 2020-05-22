BitSet bits = BitSet.valueOf(bytes);
for (int i = bits.cardinality() - 1; i >= 0; i--) {
    int bit = bits.get(i) ? 1 : 0;

    temp = /* ... */;

    bits.set(i, temp != 0);
}

byte[] modified = bits.toByteArray();
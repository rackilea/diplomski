public Test4(int tableSize) {
    if (tableSize <= 0)
        throw new IllegalArgumentException("Table Size must be positive");

    table = new Vector<LinkedList<HashPair<K, E>>>(tableSize);
    //Prepare the fast lookup table (at least that's what I think it could be called)
    for (int i = 0; i < tableSize; i++) {
        table.add(new LinkedList<HashPair<K, E>>());
    }
}
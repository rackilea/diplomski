private static BitSet toBitset(final char[] entries){
        final int length = entries.length;
        BitSet bs = new BitSet(length);
        for(int i = 0; i < length; i++){
                bs.set(i, entries[i] == '1');
        }
        return bs;
}
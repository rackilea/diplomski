public static BitSet or(final String... args){
    final BitSet temp = createBitset(args[0]);
    for(int i = 1; i < args.length; i++){
        temp.or(createBitset(args[i]));
    }
    return temp;
}

private static BitSet createBitset(final String input){
    int length = input.length();
    final BitSet bitSet = new BitSet(length);
    for(int i = 0; i < length; i++){
        // anything that's not a 1 is a zero, per convention
        bitSet.set(i, input.charAt(length - (i + 1)) == '1');
    }
    return bitSet;
}
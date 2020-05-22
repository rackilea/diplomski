public static void main(final String[] args){
    final BitSet bs =
        or("01010101", "10100000", "00001010", "1000000000000000");
    System.out.println(bs);
    System.out.println(toCharArray(bs));
}

private static char[] toCharArray(final BitSet bs){
    final int length = bs.length();
    final char[] arr = new char[length];
    for(int i = 0; i < length; i++){
        arr[i] = bs.get(i) ? '1' : '0';
    }
    return arr;
}
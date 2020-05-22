private static char[] toCharArray(final BitSet bs, int expectedBits){
        if(expectedBits < bs.length()){
            expectedBits = bs.length();
        }
        final char[] arr = new char[expectedBits];
        for(int i = 0; i < expectedBits; i++){
            arr[i] = bs.get(i) ? '1' : '0';
        }
        return arr;
    }
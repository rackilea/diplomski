final String[] arrayOfStrings = {"abc", "bdc", "ced", "bcd", "cde"};
    final int[] arrayOfPrimitiveInt = {1,6,2,8,4,6,3};
    Integer[] arrayOfIntegers= new Integer[arrayOfPrimitiveInt.length];
    for(int i=0; i < arrayOfPrimitiveInt.length; i++) {
        arrayOfIntegers[i] = arrayOfPrimitiveInt[i];
    }
    Arrays.sort(arrayOfStrings, Collections.reverseOrder());
    Arrays.sort(arrayOfIntegers, Collections.reverseOrder());
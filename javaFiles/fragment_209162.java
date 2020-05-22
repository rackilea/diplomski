public static boolean hasPairWithSum3(int[] intArray, int sum) {         
    HashSet<Integer> mySet = new HashSet<Integer>();
    int len = intArray.length;
    return IntStream.range(0, len).anyMatch(i -> {
        if (mySet.contains(intArray[i])) {
                return true;
        }
        mySet.add(sum - intArray[i]);
        return false;
    });
}
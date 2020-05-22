public static Map<Integer, Integer> lengthCounts() throws FileNotFoundException
    Map<Integer, Integer> countMap = new HashMap<>();
    while(keyboard.hasNext())
    {
        String word = keyboard.next();
        int length = word.length();
        Integer currCount = countMap.get(length);
        if (currCount == null) {
            countMap.put (length, 1);
        else {
            countMap.put (length, currCount + 1);
        }
    }
    return countMap;
}
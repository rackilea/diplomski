private int[] transform(int[][] dictionary, int[][] lookup) {
    int[] result = new int[dictionary.length];

    for (int dictionaryIndex = 0; dictionaryIndex < dictionary.length; dictionaryIndex++) {
        int[] dictionaryPair = dictionary[dictionaryIndex];

        int indexOf = -1;

        for (int index = 0; index < lookup.length; index++) {
            int[] pair = lookup[index];
            if (dictionaryPair[0] == pair[0] && dictionaryPair[1] == pair[1]) {
                indexOf = index;
                break;
            }
        }

        if (indexOf != -1) {
            result[dictionaryIndex] = indexOf;
        }
    }
    return result;
}
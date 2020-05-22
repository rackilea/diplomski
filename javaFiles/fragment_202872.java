public static void main(String[] args) {
    String[] words = new String[] { "chair", "house", "ocean", "plane",
            "dog", "TV", "grass", "money" };
    // valid list sizes for 8 words: 1, 2, 4, 8
    int listSize = 4;
    List<String[]> result = distributeRandomly(words, listSize);
    for (String[] resultList : result) {
        for (int index = 0; index < listSize; index++) {
            System.out.println((index + 1) + "/" + resultList[index]);
        }
        System.out.println();
    }
}

private static List<String[]> distributeRandomly(String[] words, int listSize) {
    // each word goes into 2 lists, so how many lists do we need?
    int listCount = words.length * 2 / listSize;
    if (listCount * listSize != words.length * 2) {
        throw new IllegalArgumentException("Number of words"
                + " must be a multiple of the size of the individual lists!");
    }
    // initialize result lists (here arrays) in fitting size
    List<String[]> listsToFill = new ArrayList<String[]>(listCount);
    for (int index = 0; index < listCount; index++) {
        listsToFill.add(new String[listSize]);
    }
    // be sure to randomly pick the given words by shuffling them
    List<String> shuffledWords = new ArrayList<String>(Arrays.asList(words));
    Collections.shuffle(shuffledWords);

    List<String[]> result = new ArrayList<String[]>(listCount);
    int maxWordPosition = listSize - 1;
    // distribute words
    for (String word : shuffledWords) {
        // word is supposed to be inserted in two lists at the same index
        int wordPosition = -1;
        // iterate result lists
        Iterator<String[]> listIterator = listsToFill.iterator();
        while (listIterator.hasNext()) {
            String[] list = listIterator.next();
            if (wordPosition == -1) {
                // look out for the first list with an empty slot
                for (int index = 0; index < listSize; index++) {
                    if (list[index] == null) {
                        // found empty slot at this index
                        wordPosition = index;
                        // insert word here (first list)
                        list[wordPosition] = word;
                        if (wordPosition == maxWordPosition) {
                            // the list is full, no more empty slots here
                            listIterator.remove();
                            result.add(list);
                        }
                        break;
                    }
                }
            } else if (list[wordPosition] == null) {
                // found second list with an empty slot at the same index
                list[wordPosition] = word;
                if (wordPosition == maxWordPosition) {
                    // the list is full, no more empty slots here
                    listIterator.remove();
                    result.add(list);
                }
                // we are done with this word
                break;
            }
        }
        // shuffle result lists again, to ensure randomness
        Collections.shuffle(listsToFill);
    }
    return result;
}
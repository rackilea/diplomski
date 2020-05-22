public static List<List<Item>> distribute(List<Item> items, int y, int z) {
    // Create list of items * z
    List<Item> allItems = new ArrayList<>();
    for (int i = 0; i < z; i++)
        allItems.addAll(items);
    Collections.shuffle(allItems);

    // Randomly shuffle list
    List<List<Item>> result = new ArrayList<>();
    int totalItems = items.size()*z;
    for (int i = 0; i < totalItems; i += y)
        result.add(new ArrayList<Item>(allItems.subList(i, Math.min(totalItems, i+y))));

    // Swap items in lists until lists are unique
    for (List<Item> resultList : result) {
        // Find duplicates
        List<Item> duplicates = new ArrayList<>(resultList);
        for (Item item : new HashSet<Item>(resultList))
            duplicates.remove(item);

        for (Item duplicate : duplicates) {
             // Swap duplicate for item in another list
            for (List<Item> swapCandidate : result) {
                if (swapCandidate.contains(duplicate))
                    continue;
                List<Item> candidateReplacements = new ArrayList<>(swapCandidate);
                candidateReplacements.removeAll(resultList);
                if (candidateReplacements.size() > 0) {
                    Item replacement = candidateReplacements.get(0);
                    resultList.add(resultList.indexOf(duplicate), replacement);
                    resultList.remove(duplicate);
                    swapCandidate.add(swapCandidate.indexOf(replacement), duplicate);
                    swapCandidate.remove(replacement);
                    break;
                }
            }
        }
    }

    return result;
}
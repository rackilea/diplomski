private static int getUniqueCountUsingSort(List<String> list) {
    if (list.size() < 2) { // obvious case.
        return list.size();
    }

    List<String> listCopy = new ArrayList<>(list);
    Collections.sort(listCopy);
    int uniqueCount = 1;
    for (int i = 1; i < listCopy.size(); i++) { // starts at 1.
                    // Compare with previous item in the sorted list.
        if (!listCopy.get(i).equals(listCopy.get(i-1))) {
            uniqueCount ++;
        }
    }
    return uniqueCount;
}
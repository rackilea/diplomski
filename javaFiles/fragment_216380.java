public static List<Integer> sumConsecutives(List<Integer> s) {
    ArrayList<Integer> returnList = new ArrayList<>();
    int currentRepeating = 0;
    for (int i : s) {
        if (returnList.isEmpty() || currentRepeating != i) {
            currentRepeating = i;
            returnList.add(i);
        } else {
            returnList.set(returnList.size() - 1, returnList.get(returnList.size() - 1) + i);
        }
    }
    return returnList;
}
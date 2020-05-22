private static int getUniqueCountByHand(List<String> list) {

    int uniqueCount = 0;
    for (int i = 0; i < list.size(); i++) {
        boolean isUnique = true;
        // look if there is another entity before that is equal to this one.
        for (int j = 0; j < i; j++) {
            if (list.get(j).equals(list.get(i))) {
                isUnique = false;
            }
        }
        if (isUnique) {
            uniqueCount ++;
        }
    }

    return uniqueCount;
}
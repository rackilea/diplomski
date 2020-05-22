public static void removeDuplicate(ArrayList<Integer> list) {
    int i = list.size() - 1;

    while (i > -1) {
        // check for duplicate
        for (int j = 0; j < i; j++) {
            if (list.get(i) == list.get(j)) {
                // is duplicate: remove
                list.remove(i);
                break;
            }
        }
        i--;
    }
}
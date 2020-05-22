static boolean noDupes(int[][] array) {
    for (int i=0; i < array.length; i++) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j=0; j < array.length; j++) {
            if (set.contains(array[j][i])) return false;
            set.add(array[j][i]);
        }
    }
    return true;
}
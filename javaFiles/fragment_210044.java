public static int[] getIndex(List<String[]> arrayList, String tofind) {
    int[] index = new int[]{-1, -1};
    for (int i = 0; i < arrayList.size(); i++) {
        String[] currLine = arrayList.get(i);
        for (int j = 0; j < currLine.length; j++) {
            if (currLine[j].equals(tofind)) {
                index = new int[]{i + 1, j + 1};
                return index;
            }
        }
    }
    return index;
}
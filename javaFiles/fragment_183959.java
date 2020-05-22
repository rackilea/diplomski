public static void main(String[] args) {
    int n = 4;
    int k = 2;
    int[][] result = combinations(n, k);
    System.out.println(Arrays.deepToString(result));
    //this will print:
    //[[0,0],[0,1],[0,2],[0,3],[1,0],[1,1],[1,2],[1,3],[2,0],[2,1],[2,2],[2,3],[3,0],[3,1],[3,2],[3,3]]
}

public static int[][] combinations(int n, int k) {
    int[] nArray = IntStream.range(0, n).toArray();
    List<String> list = new ArrayList<String>();
    combinationStrings(k, nArray, "", list);
    return fromArrayListToArray(list, k);
}

private static void combinationStrings(int k, int[] nArray, String currentString, List<String> list) {
    if (currentString.length() == k) {
        list.add(currentString);
    } else {
        for (int i = 0; i < nArray.length; i++) {
            String oldCurrent = currentString;
            currentString += nArray[i];
            combinationStrings(k, nArray, currentString, list);
            currentString = oldCurrent;
        }
    }
}

private static int[][] fromArrayListToArray(List<String> list, int k) {
    int[][] result = new int[list.size()][k];
    for (int i=0;i<list.size();i++) {
        String[] split = list.get(i).split("\\B");
        for (int j = 0; j < split.length; j++) {
            result[i][j] = Integer.parseInt(split[j]);
        }
    }
    return result;
}
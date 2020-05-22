public static void main(String[] args) {
    ArrayList<int[][]> test = new ArrayList<int[][]>();
    int[][] one = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] two = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] three = { { 9, 7, 5 }, { 1, 2, 4 }, { 5, 6, 7 } };
    test.add(one);
    if (contains(test, two)) {
        System.out.println("Found two");
    }
}
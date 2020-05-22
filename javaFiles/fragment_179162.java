public static void main(String[] args) {
    String[][] temp = {
        { "Fox", "32", "One" },
        { "Dog", "45", "Two" },
        { "Cat", "34", "Three" },
        { "Snake", "3", "Four" }
    };

    Arrays.sort(temp, new Comparator<String[]>() {
        @Override
        public int compare(String[] row1, String[] row2) {
            return Integer.compare(
                    Integer.parseInt(row1[1]), Integer.parseInt(row2[1]));
        }
    });

    System.out.println(Arrays.deepToString(temp));
}
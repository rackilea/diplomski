public static void fillElements(char[][] array, int elements) {
    if (array.length * array[0].length < elements) throw new IllegalArgumentException();
    boolean[][] filled = new boolean[array.length][array[0].length];
    int i = 0;
    while (i < elements) {
        int x = (int) (Math.random() * array.length);
        int y = (int) (Math.random() * array[0].length);
        if (!filled[x][y]) {
            filled[x][y] = true;
            array[x][y] = 'B';
            i++;
        }
    }
}
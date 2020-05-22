public static void main(String[] args) {
    int[] indeks = new int[4];
    indeks[0] = 1;
    indeks[1] = 3;
    indeks[2] = 0;
    indeks[3] = 2;
    String[] islands = new String[4];
    islands[0] = "Bermudy";
    islands[1] = "Fiji";
    islands[2] = "Azory";
    islands[3] = "Kozumel";
    int y = 0;
    int ref;
    while (y < 4) {
        ref = indeks[y];
        System.out.print("Island = ");
        System.out.println(islands[ref]);
        y = y + 1;
    }
}
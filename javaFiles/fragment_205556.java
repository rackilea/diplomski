class Array {

    static String arrayPicture[][];

    public static void main(String[] args) {

        arrayPicture = new String[5][5];

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                arrayPicture[i][j] = " ";
            }
        }
        horizontalLine(0, 0, 4);
        horizontalLine(1, 1, 3);
    }

    public static void horizontalLine(int x1, int y1, int x2) {

        for (int k = x1; k < x2; k++) {
            arrayPicture[y1][k] = "*";
        }
        picture(y1);
        System.out.println();
    }

    public static void picture(int startIndex) {
        for (int i = startIndex; i < 5; i++) { // start from startIndex, not necessary 0 !
            for (int j = 0; j < 5; j++) {
                System.out.print(arrayPicture[i][j]);
            }
        }
    }
}
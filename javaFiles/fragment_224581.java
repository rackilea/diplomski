public static void drawTriangleAndSquare(int widthS, int heightS) {
    // number of leading spaces in front of triangle
    int k = 2 * heightS - 5;

    // print square
    for (int i = 0; i < heightS; i++) {
        for (int j = 0; j < widthS; j++) {
            System.out.print("* ");
        }

        // print triangle
        System.out.print("\t");
        for (int j = 0; j < k; j++) {
            System.out.print(" ");
        }

        k--;

        for (int j = 0; j <= i; j++) {
            System.out.print("* ");
        }

        System.out.println();
    }
}

public static void main(String[] args) {
    drawTriangleAndSquare(5, 4);
}
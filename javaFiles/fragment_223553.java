public void printPyramid (int input) {
    for (int row = 1; row <= input; row++) {
        for (int whitespace = input - 1; whitespace >= row; whitespace--) {
            System.out.print(" ");
        }
        System.out.print("*");
        for (int circle = 1; circle < row; circle++) {
            System.out.print("o*");
        }
        System.out.println();
    }
}
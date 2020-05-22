public static void main(String[] args) {
    int n = 1;
    for (int r = 0; r < 4; r++) {
        for (int c = 0; c < r+1; c++) {
            System.out.print(n++);
            if (c != r) System.out.print(" ");
        }
        System.out.println();
    }
}
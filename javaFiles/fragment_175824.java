class Main {
    public static void main(String[] args) {
        int i, j, k;
        for (i = 1; i <= 3; i++) {
            for (j = 2; j >= i; j--) {
                System.out.print("_");
            }
            for (k = 1; k <= (2 * i - 1); k++) {
                System.out.print(i * 2 - 1);
            }
            for (j = 2; j >= i; j--) {
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
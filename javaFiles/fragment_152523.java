public static void main(String[] args) {
    final int SIZE = 9;
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            System.out.print(i < j ? "+" : "-");
        }
        System.out.println();
    }
}
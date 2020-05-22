public void printXXX(char c, int... ints) {
    for (int i : ints) {
        for (j = 0; j < i; j++) {
            System.out.print(c);
        }
        System.out.println();
    }
}
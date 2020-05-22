final int initial = num; // <-- add this
for (int i = num; i >= 1; i--) {
    for (int space = 1; space <= initial - i; ++space) { // <-- use initial instead of num
        System.out.print("  ");
    }
    for (int k = num; k >= 1; k--) {
        System.out.print(k + " ");
    }
    for (int k = 2; k <= num; k++) { // <-- j should still work of course...
        System.out.print(k + " ");
    }
    System.out.println();
    num--;
}
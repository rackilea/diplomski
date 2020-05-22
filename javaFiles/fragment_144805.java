int i, j, k;
int n = 5;

for (i = 1; i <= n; i++) {
    for (j = 0; j < (n - i); j++) {
        System.out.print("  ");
    }
    for (j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    for (k = 1; k < i; k++) {
        System.out.print("* ");
    }
    System.out.print("\n");
}

for (i = n - 1; i >= 1; i--) {
    for (j = 0; j < (n - i); j++) {
        System.out.print("  ");
    }
    for (j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    for (k = 1; k < i; k++) {
        System.out.print("* ");
    }
    System.out.print("\n");
}
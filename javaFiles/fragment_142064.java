public static void Print(int n) {
    for (int i = n; i > 0; i--) {
        System.out.print(i);
        if (i == 1) {
            System.out.print("=");
            continue;
        }
        System.out.print("x");
    }
}
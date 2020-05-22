public static void printMany(int count, String s) {
    if (count == 0)
        return;

    System.out.print(s);
    printMany(count - 1, s);
}

public static void upperhalf(int count, int max) {
    if (count == 0)
        return;

    printMany(max - count, " ");
    printMany(count, "* ");

    System.out.println();

    upperhalf(count - 1, max);
}

public static void lowerhalf(int count, int max) {
    if (count == max)
        return;

    printMany(max - count - 1, " ");
    printMany(count + 1, "* ");

    System.out.println();

    lowerhalf(count + 1, max);
}

public static void hourglass(int n) {
    upperhalf(n, n);
    lowerhalf(0, n);
}
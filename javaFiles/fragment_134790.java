public static void downUp(int limit) {

    downUp(1, limit);
}

private static void downUp(int value, int limit) {

    if (((2 * limit) - value) ==0 ) { return;}
    if (value > limit) {
        System.out.print((2 * limit) - value);
    } else {
        System.out.print(value);
    }

    downUp(++value, limit);
}
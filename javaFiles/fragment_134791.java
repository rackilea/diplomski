class UpDown {

    static int value = 1;

    public static void downUp(int limit) {

        if (((2 * limit) - value) ==0 ) { return;}
        if (value > limit) {
            System.out.print((2 * limit) - value);
        } else {
            System.out.print(value);
        }
        value++;
        downUp(limit);
    }
}
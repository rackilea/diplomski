public static void main(String[] args) {
    int low = 65, high = 90;
    System.out.println(addWithinInterval(85, 10, low, high));
}

private static int addWithinInterval(int value, int add, int low, int high) {
    return (value - low + add) % (high - low + 1) + low;
}
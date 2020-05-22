private static void increment(int arg) {
    arg = arg + 1;
    System.out.println("incremented: " + arg);
}

public static void main(String[] args) {
    int value = 1;
    System.out.println("before: " + value);
    increment(value);
    System.out.println("after: " + value);
}
public static void main(String... args) {
    double a = -0.0d;
    double b = 0.0d;
    if (a == b) {
        System.out.println("a == b");
    }
    if (Double.compare(a, b) == 0) {
        System.out.println("Double.compare(a, b) == 0");
    }
}
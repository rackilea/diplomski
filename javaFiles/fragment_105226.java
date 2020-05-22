public static void main(String[] args) {
    long num = 123456789;

    while (num != 0) {
        System.out.println(num % 10);
        num = num / 10;
    }
}
public static void main(String[] args) {
    for (int i = 1; i <= 21; i++) {
        if (i != 1) {
            System.out.print(", ");
        }
        if (i % 4 == 0) {
            System.out.print("X");
        } else {
            System.out.print(fib(i));
        }
    }
}
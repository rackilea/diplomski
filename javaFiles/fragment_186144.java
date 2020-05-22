public static void main(String[] args) {
    for (int i = 15; i < 20; i++) {
        long a = Math.round(Math.pow(2, i));
        long b = Math.round(Math.pow(2, i + i));
        int c = (int) b;
        System.out.printf("i = %d, a = %d, b = %d, c = %d%n", i, a, b, c);
    }
}
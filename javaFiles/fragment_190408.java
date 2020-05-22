public static void main(String[] args) {
        int i = 234, n;
        while (i > 0) {
            n = i % 10;
            i = i / 10;
            System.out.print(n);
        }
}
public static void main(String[] args) {
    outer:
    for (int a = 2; a <= 1000; a++) {
        for (int b = 2; b < a; b++) {
            if (a % b == 0) {
                continue outer;
            }
        }
        System.out.println(a);
    }
}
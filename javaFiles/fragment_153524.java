public static void main(String[] args) {
    int x = -5;
    int y = +x;
    System.out.println(y); // - + => -

    int a = 5;
    int b = -a;
    System.out.println(b); // + - => -

    int c = 5;
    int d = +5;
    System.out.println(d); // + + => +

    int m = -5;
    int n = -m;
    System.out.println(n); // - - => +
}
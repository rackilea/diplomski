public static void main(String[] args) {

    int x = 10111;

    int num = 0;

    int digitval = 1;

    for (int i = 1; i <= x; i *= 10) {

        int binaryDigit = x/i%10;
        num += digitval * binaryDigit;
        digitval *= 2;
    }
    System.out.println("\""+ x + "\" in binary is equivalent to " + num + " in decimal");
}
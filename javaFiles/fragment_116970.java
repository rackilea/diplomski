public static void main(String[] args) {

    String final0 = calculate(-3, 13, -4);
    System.out.println(final0);

}
public static String calculate(int a, int b, int c) {
    String final0 ;
    int i = -1 * b; // -1 * 13 = -13
    System.out.println(i);

    int j = 4 * a * c; // 4 * -3 * -4  = 4 * 12  = 48
    System.out.println(j);

    double sqrt = Math.sqrt((b * b) - j); // sqrt ((13 * 13) - 48) = sqrt(169 - 48) = sqrt(121) = 11
    System.out.println(sqrt);

    double d = i + sqrt; // -13 + 11 = -2
    System.out.println(d);

    int k = 2 * a; // 2* -3 = -6
    System.out.println(k);

    double done1 = d / k; // -2 / -6 = 1/3 = 0.3333333333
    System.out.println(done1);

    double done2 = (i - sqrt) / k;
    final0 = "x = " + (done1) + " or x = " + (done2);

    return final0;
}
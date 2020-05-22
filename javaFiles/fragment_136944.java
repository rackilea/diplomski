try {
    int zero = 0;
    int y = 2/zero;

    Object s = null;
    System.out.println(s.toString());
} catch(NullPointerException e) {
    System.out.println(e);
} catch(ArithmeticException e) {
    System.out.println(e);
}
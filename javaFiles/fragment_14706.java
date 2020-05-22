class Test {
    public static void main(String[]args) {
        double d1 = 1234;
        double d2 = 1234.567;
        System.out.println(String.valueOf(d1).replaceFirst("\\.0+$", ""));
        System.out.println(String.valueOf(d2).replaceFirst("\\.0+$", ""));
    }
}
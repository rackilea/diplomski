public class Test {

    public static void main(final String[] args) {
        System.out.println(format(123.456789123456d));
        System.out.println(format(12345.6789123456d));
        System.out.println(format(0.0123456789123456d));
        System.out.println(format(0.000123456789123456d));
    }

    public static String format(final double d) {
        final int before = 16 - Integer.toString((int) d).length();
        final String format = "%" + (16 + before) + "." + before + "f";
        return String.format(format, d);
    }
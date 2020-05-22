public class Phonkw {
    public static String phonkw1(final String tampon) {
        return tampon == null ? "" : tampon.replaceAll("^([BCDFGHJKLMNPQRSTVWXZ])W", "$1OU");
    }

    public static void main(final String... args) {
        for (final String arg : args)
            System.out.println(phonkw1(arg));
    }
}
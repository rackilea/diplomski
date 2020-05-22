public class Phonkw {
    private static final String CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ";
    public static boolean isConsonant(final char c) {
        return CONSONANTS.indexOf(c) != -1;
    }
    public static String phonkw1(final String tampon) {
        if (tampon == null) return "";
        if (tampon.length() < 2) return tampon;
        if (tampon.charAt(1) == 'W' && isConsonant(tampon.charAt(0)))
            return tampon.charAt(0) + "OU" + tampon.substring(2);
        return tampon;
    }

    public static void main(final String... args) {
        for (final String arg : args)
            System.out.println(phonkw1(arg));
    }
}
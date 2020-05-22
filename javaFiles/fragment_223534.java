public class Caesar {
    private static final String PLAIN = "abcdefghijklmnopqrstuvwxyz"; // fix scope

    private static final String CIPHER = "defghijklmnopqrstuvwxyzabc"; // fix scope

    public static String encrypt(String str)
    {
        String result = "";
        int x; // indexOf returns int
        for (final char ch : str.toCharArray()) { // str is not an Iterable
            x = PLAIN.indexOf(ch);
            if (x != -1) {
                result = result + CIPHER.charAt(x);
            } else {
                result = result + ch;
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        System.out.println(encrypt("James"));
    }
}
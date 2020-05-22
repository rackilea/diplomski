public class Example {

    public static void main(String[] args) {

        String s1 = "abcabcqmapcab";
        String s2 = "cq*pc";

        String pattern = s2.replaceAll("\\*", ".+"); // or ".*"
        Matcher m = Pattern.compile(pattern).matcher(s1);
        if (m.find())
            System.out.println(m.start());
    }
}
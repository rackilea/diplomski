public static void main(String[] args)
{
    final String myString="Google is a great search engine<as:Some stuff heres>";

    Pattern pat = Pattern.compile("^[^<]+<as:(.*)s>$");

    Matcher m = pat.matcher(myString);
    if (m.matches()) {
        System.out.println(m.group(1));
    }
}
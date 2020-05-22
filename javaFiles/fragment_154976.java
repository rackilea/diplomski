public static void looping()
{
    final String myString="Google is a great search engine"
            + "<as:Some stuff heresss>Here is Facebook<as:More Stuffs>"
            + "Something else at the end" +
            "<as:Stuffs>" +
            "<as:Yet More Stuffs>";

    Pattern pat = Pattern.compile("([^<]+)?(<as:(.*?)s>)?");

    Matcher m = pat.matcher(myString);
    List<String> col = new ArrayList<>();

    while (m.find()) {
        String prefix = m.group(1);
        String contents = m.group(3);

        if (prefix != null) { col.add(prefix); }
        if (contents != null) { col.add(contents); }
    }

    System.out.println(col);
}
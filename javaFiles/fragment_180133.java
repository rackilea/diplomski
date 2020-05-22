@Test
public void testRegex() {
    Pattern p = Pattern.compile("([\"\\s]|&quot;)(https?://.*?)(?=\\1)", 
        Pattern.CASE_INSENSITIVE);
    final String URL = "http://test.url/here.php?var1=val&var2=val2";
    final String INPUT = "some text " + URL + " more text + \"" + URL + 
            "\" more then &quot;" + URL + "&quot; testing greed &quot;";

    Matcher m = p.matcher(INPUT);
    while( m.find() ) {
        System.out.println("Found: " + m.group(2));
    }
}
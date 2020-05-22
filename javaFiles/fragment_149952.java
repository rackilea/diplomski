private static void test(String htmlFile) {
    File input = null;
    Document doc = null;
    Element specificIdDiv = null;

    try {
        input = new File(htmlFile);
        doc = Jsoup.parse(input, "ASCII", "");
        doc.outputSettings().charset("ASCII");
        doc.outputSettings().escapeMode(EscapeMode.base);

        /** Get Element id = post_message_1 **/
        specificIdDiv = doc.getElementById("post_message_1");

        if (specificIdDiv != null ) {
            System.out.println("content: " + specificIdDiv.ownText());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
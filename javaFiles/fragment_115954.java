@Test
public void canGetTextFromAPElement() {
    String html = "<html> \n" +
            "   <head></head>\n" +
            "   <body>\n" +
            "      <p>\n" +
            "        \"Text\"\n" +
            "        <br>\n" +
            "        \"Some more Text\"\n" +
            "        <br> \n" +
            "        \"Even more text\"\n" +
            "        </p>\n" +
            "  </body>\n" +
            "</html>";

    Document doc = Jsoup.parse(html);

    Elements elements = doc.select("p");

    assertThat(elements.size(), is(1));
    assertThat(elements.get(0).text(), is("\"Text\" \"Some more Text\" \"Even more text\""));
}
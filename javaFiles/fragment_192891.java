@Test
public void testTextExtract() {
    // https://github.com/paepcke/CorEx/blob/master/src/extraction/HTMLUtils.java
    String htmls[] = {
            "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "\n"
                    + "<h1>My First Heading</h1>\n" + "\n"
                    + "<p>My first paragraph.</p>\n" + "\n" + "</body>\n" + "</html>",
            "<html>\n"
                    + "<body>\n"
                    + "\n"
                    + "<div id=\"myDiv\" name=\"myDiv\" title=\"Example Div Element\">\n"
                    + "  <h5>Subtitle</h5>\n"
                    + "  <p>This paragraph would be your content paragraph...</p>\n"
                    + "  <p>Here's another content article right here.</p>\n"
                    + "</div>" + "\n" + "Text at end of body</body>\n" + "</html>" };
    int expectedSize[] = { 2, 4 };
    String expectedInfo[][]={
        { 
            "line 5 col 5 to  line 5 col 21: My First Heading",
            "line 7 col 4 to  line 7 col 23: My first paragraph."
        },
        { 
            "line 5 col 7 to  line 5 col 15: Subtitle",
            "line 6 col 6 to  line 6 col 55: This paragraph would be your content paragraph...",
            "line 7 col 6 to  line 7 col 48: Here's another content article right here.",
            "line 8 col 7 to  line 9 col 20: Text at end of body"
        }
    };
    int i = 0;
    for (String html : htmls) {
        SourceTextExtractor extractor=new SourceTextExtractor();
        List<TextResult> textParts = extractor.extractTextSegments(html);
        // List<String> textParts = HTMLCleanerTextExtractor.extractText(html);
        int j=0;
        for (TextResult textPart : textParts) {
            System.out.println(textPart.getInfo());
            assertTrue(textPart.getInfo().startsWith(expectedInfo[i][j]));
            j++;
        }
        assertEquals(expectedSize[i], textParts.size());
        i++;
    }
}
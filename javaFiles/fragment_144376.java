@Test
public void testXmlUnit() {
    String myControlXML = "<test><elem>a</elem><elem>b</elem></test>";
    String expected = "<test><elem>b</elem><elem>a</elem></test>";
    assertThat(myControlXML, isSimilarTo(expected)
            .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText)));
    //In case you wan't to ignore whitespaces add ignoreWhitespace().normalizeWhitespace()
    assertThat(myControlXML, isSimilarTo(expected)
        .ignoreWhitespace()
        .normalizeWhitespace()
        .withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText)));
}
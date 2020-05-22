@Test
public void normalizeString(){
    StringBuilder ret =  new StringBuilder();
    Matcher matches = Pattern.compile( "[A-Z0-9]+" ).matcher("P-12345678-P");

    while (matches.find()) {
        ret.append(matches.group());
    }

    assertEquals("P12345678P", ret.toString());
}
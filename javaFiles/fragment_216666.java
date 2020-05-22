@Test
public void test() {
    final String input = "someother text !style_delete [company code : 43ev4] between text !style_delete [organiztion : 0asj9] end of line text";
    // my regexp:strong text
    // final String regex = "(!style_delete\\s\\[[a-zA-Z0-9\\s:]*\\])";
    // regexp from Trinmon:
    final String regex = "(!style_delete\\s*\\[[^\\]]*\\])";

    final Matcher m = Pattern.compile(regex).matcher(input);

    final List<String> matches = new ArrayList<>();
    while (m.find()) {
        matches.add(m.group(0));
    }

    assertEquals(2, matches.size());
    assertEquals("match 1: ", matches.get(0), "!style_delete [company code : 43ev4]");
    assertEquals("match 2: ", matches.get(1), "!style_delete [organiztion : 0asj9]");
}
public class RegExTest {

    Pattern p = Pattern.compile("<([^>]*)>\\s+[<]?([^>]*)[>]?");

    @Test(dataProvider = "data")
    public void testRegEx(String line, String k, String v) {
        Matcher m = p.matcher(line);
        if (! m.matches() ) {
            Assert.fail("no match");
        }
        Assert.assertEquals(m.group(1), k);
        Assert.assertEquals(m.group(2), v);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {"<foo.bar> <foo>", "foo.bar", "foo"},
                {"<foo bar> foo", "foo bar", "foo"},
                {"<foobar1> foo", "foobar1", "foo"}
        };
    }

}
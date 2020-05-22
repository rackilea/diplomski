@Test
public void ignoringMultipleAttributesWorks() throws JSONException {
    String expected = "{\"timestamp\":1234567, \"a\":5, \"b\":3 }";
    String actual = "{\"timestamp\":987654, \"a\":1, \"b\":3 }";

    JSONAssert.assertEquals(expected, actual,
            new CustomComparator(JSONCompareMode.LENIENT,
                    new Customization("timestamp", (o1, o2) -> true),
                    new Customization("a", (o1, o2) -> true)
            ));
}
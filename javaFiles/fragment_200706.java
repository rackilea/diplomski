@Test
public void extendingCustomComparatorToAllowToCompletelyIgnoreCertainAttributes() throws JSONException {
    // AttributeIgnoringComparator completely ignores some of the expected attributes
    class AttributeIgnoringComparator extends CustomComparator{
        private final Set<String> attributesToIgnore;

        private AttributeIgnoringComparator(JSONCompareMode mode, Set<String> attributesToIgnore, Customization... customizations) {
            super(mode, customizations);
            this.attributesToIgnore = attributesToIgnore;
        }

        protected void checkJsonObjectKeysExpectedInActual(String prefix, JSONObject expected, JSONObject actual, JSONCompareResult result) throws JSONException {
            Set<String> expectedKeys = getKeys(expected);
            expectedKeys.removeAll(attributesToIgnore);
            for (String key : expectedKeys) {
                Object expectedValue = expected.get(key);
                if (actual.has(key)) {
                    Object actualValue = actual.get(key);
                    compareValues(qualify(prefix, key), expectedValue, actualValue, result);
                } else {
                    result.missing(prefix, key);
                }
            }
        }
    }

    String expected = "{\"timestamp\":1234567, \"a\":5}";
    String actual = "{\"a\":5}";

    JSONAssert.assertEquals(expected, actual,
            new AttributeIgnoringComparator(JSONCompareMode.LENIENT,
                    new HashSet<>(Arrays.asList("timestamp")))
            );
}
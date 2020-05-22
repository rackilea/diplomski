class StringVarArgsMatcher implements ArgumentMatcher<String>,VarargMatcher {

    private String[] expectedValues;
    private int count = 0;

    StringVarArgsMatcher(String... expectedValues) {
        this.expectedValues = expectedValues;
    }

    @Override
    public boolean matches(String argument) {

        if (count >= expectedValues.length) {
            return false;
        }

        boolean result = "".equals(expectedValues[count]) || argument.endsWith(expectedValues[count]);
        count++;
        return result; 
    }
}
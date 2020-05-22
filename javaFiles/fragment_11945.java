public class SetMatcher implements IArgumentMatcher {

    private List<String> valuesToMatch;
    private List<String> remainingValues;
    private String currentValue = null;
    private int timesMatched = 0;
    private int setMatches;

    public SetMatcher(final List<String> valuesToMatch, final int times) {
        this.valuesToMatch = new ArrayList<String>(valuesToMatch);
        this.remainingValues = new ArrayList<String>(valuesToMatch);
        this.setMatches = times;
    }

    public String use() {
        EasyMock.reportMatcher(this);

        return null;
    }

    public void appendTo(StringBuffer buffer) {
        if (this.remainingValues.size() == 0) {
            buffer.append("all values in " + this.valuesToMatch + " already matched " + this.setMatches + " time(s)");
        } else {
            buffer.append("match " + this.valuesToMatch + " " + this.setMatches + " time(s) each");
        }
    }

    public boolean matches(Object other) {

        if (this.timesMatched >= this.setMatches) {
            this.currentValue = null;
            this.timesMatched = 0;
        }

        if (null == this.currentValue) {
            if (this.remainingValues.contains(other)) {
                this.currentValue = (String) other;
                this.timesMatched = 1;
                this.remainingValues.remove(other);

                return true;
            }
        } else if (this.currentValue.equals(other)) {
            this.timesMatched++;

            return true;
        }

        return false;
    }

}
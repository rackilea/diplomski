public enum RuleItem {
    MORE_THAN(1, "rulesName.moreThan"),
    LESS_THAN(2, "rulesName.lessThan"),
    MORE_OR_EQUAL(3, "rulesName.moreOrEqual");

    private int value;
    private String representation;

    private RuleItem(int value, String representation) {
        this.value = value;
        this.representation = representation;
    }

    public String getStringRepresentation() {
         return representation;
    }
}
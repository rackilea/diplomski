public enum myEnum {
    BASIC(1, "An error occurred"),
    WITH_ERRORID(2, "Error id: {0}"),
    DETAILED(3, "Problem in record {0} with index {1}");
    private int key = 0;
    private String format = null;

    private myEnum(int aKey, String aFormat) {
        this.key=aKey;
        this.format=aFormat;
    }

    /**
     * This will take whatever input you provide and use the enum instance format
     * string to generate a message.
     */
    public String getMessage(Object... someContents) {
        return MessageFormat.format(this.format, someContents);
    }
}
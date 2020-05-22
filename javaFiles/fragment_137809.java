private enum Radio {
    SPACE(" ", CodeEntry::getButtonWhite),
    PLUS("+", CodeEntry::getButtonGreen),
    MINUS("-", CodeEntry::getButtonRed);

    private final String value;

    private final Function<CodeEntry, T> buttonFunction;

    private Radio(final String value, Function<CodeEntry, T> buttonFunction) {
        this.value = value;
        this.buttonFunction = buttonFunction;
    }

    public static void setSelection(final CodeEntry entry, final String flag) {
        Arrays.stream(values())
              .filter(radio -> flag.equals(radio.value))
              .findAny()
              .ifPresent(radio -> {
                 radio.buttonFunction.apply(entry).setSelection(true);
              });
    }
}
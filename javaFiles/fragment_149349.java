enum Currency {

    USD("United States Dollar", Locale.US),
    GBR("Great Britain Pound", Locale.UK),
    AUD("Australian Dollar", new Locale("en", "AUS")),
    EUR("Euro", /*here little complicated*/ Locale.FRANCE);

    private final Locale locale;
    private final String description;

    Currency(String description, Locale locale) {
        this.description = description;
        this.locale = locale;
    }

    @Override public String toString() {
    return this.name() + " - " + this.description;
    //... getters
}
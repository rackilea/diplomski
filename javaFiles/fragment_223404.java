public enum States {
    ...
    MASSACHUSETTS("Massachusetts",  "MA",   true),
    MICHIGAN     ("Michigan",       "MI",   false),
    ...; // all 50 of those

    private final String full;
    private final String abbr;
    private final boolean originalColony;

    private States(String full, String abbr, boolean originalColony) {
        this.full = full;
        this.abbr = abbr;
        this.originalColony = originalColony;
    }

    public String getFullName() {
        return full;
    }

    public String getAbbreviatedName() {
        return abbr;
    }

    public boolean isOriginalColony(){
        return originalColony;
    }
}
public enum StateData implements State {

    ALABAMA("Alabama", "AL"),
    ALASKA("Alaska", "AK"),
    ARIZONA("Arizona", "AZ"),
    ARKANSAS("Arkansas", "AR"),
    CALIFORNIA("Californiaa", "CA");

    private final String shortName;
    private final String fullName;

    private StateData(final String shortName, final String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }

    @Override
    public String fullName() {
        return fullName;
    }

    @Override
    public String shortName() {
        return shortName;
    }
}
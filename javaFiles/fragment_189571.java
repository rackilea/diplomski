public enum RandomEnum {

    StartHere("Start Here"),
    StopHere("Stop Here");

    private String value;

    RandomEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static RandomEnum getEnum(String value) {
        for(RandomEnum v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
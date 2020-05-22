public enum AipType {
    Unknown(-1),
    None(0),
    AipMod(1),
    AipNoMod(2);

    private final int id;
    AipType(int id) {this.id = id;}
    public int getValue() {return id;}

    public static AipType fromValue(int id) {
        for (AipType aip: values()) {
            if (aip.getValue() == id) {
                return aip;
            }
        }
        return null;
    }
}
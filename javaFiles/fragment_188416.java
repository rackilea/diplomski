enum Colour implements IBaseEnum {
    VAL1("string")
    ;

    private final String val;

    Colour(String v) {
        this.val = v;
    }

    @Override
    public String enumVal() {
        return this.val;
    }

    public static Colour fromString(String s) {
        return IBaseEnum.fromString(s, values());
    }
}
package test;

public class WicketTypeState extends IntEnumUserType<WicketType> {
    private WicketType wicketType;

public WicketTypeState() {
    // we must give the values of the enum to the parent.
    super(WicketType.class, WicketType.values());
}

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(final WicketType wicketType) {
        this.wicketType = wicketType;
    }
}
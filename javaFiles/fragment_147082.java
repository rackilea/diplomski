public enum SwitchState {
    ON(true, new ThemeResource("img/on.png")), OFF(false, new ThemeResource("img/off.png"));

    private final boolean value;
    private final ThemeResource icon;

    SwitchState(boolean value, ThemeResource icon) {
        this.value = value;
        this.icon = icon;
    }

    public boolean getValue() {
        return value;
    }

    public ThemeResource getIcon() {
        return icon;
    }

    public static SwitchState from(boolean value) {
        return value ? ON : OFF;
    }
}
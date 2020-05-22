public enum Privileges {
    REGULAR("Regular"), ADMINISTRATOR("Administrator");
    private String text;
    private Privileges(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
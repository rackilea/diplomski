public enum Status {
    JOHN("single"),
    ALEX("married"),
    MARTHA("not known");
    private String value;
    private Status(String str) {
       value = str;
    }
    public String getValue() {
        return this.value;
    }
}
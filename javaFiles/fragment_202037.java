package test;

interface Constants {
    String DESC = "A String";
}

public enum Enumtricks {
    Enumtricks(Constants.DESC);
    private final String description;
    private Enumtricks(final String description) {
        this.description = description;
    }
    public String value() {
        return this.description;
    }
}
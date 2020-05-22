class Weekday {
    public final String name;

    public Weekday(String name) {
        this.name = name;
    }
}

Weekday monday = new Weekday("Monday");
monday.name = "Tuesday";  // error: cannot reassign final variable
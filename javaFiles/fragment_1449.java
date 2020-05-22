class Testing {

    String name;
    final Details details;

    private Testing(Details details) {
        this.details = details;
    }

    Testing() {
        this(new Details());
    }

    Testing copy() {
        return new Testing(details);
    }

    void setName(String name) {
        this.name = name;
    }

    void setSubject(String subject) {
        this.details.subject = subject;
    }

    String asString() {
        return String.format("Name: %s\n%s", name, details.asString());
    }
}
public static class NameGroup {
    // fields here

    public NameGroup(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public void incrementCount() {
        this.count++;
    }

    // other constructors, getters and setters here
}
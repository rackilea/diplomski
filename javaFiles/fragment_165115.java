class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
            .add("firstName", firstName)
            .add("lastName", lastName)
            .toString();
    }
}
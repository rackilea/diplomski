class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
            .append("firstName", firstName)
            .append("lastName", lastName)
            .toString();
    }
}
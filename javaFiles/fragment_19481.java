class Person {
    private String firstName;
    private String lastName;

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }
}
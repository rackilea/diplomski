// extract common code to method to avoid duplication
private String getInitial(String s) {
    return (s != null && !s.isEmpty()) ? s.substring(0, 1) : "";
}

private String getInitials(Person person) {
    return getInitial(person.getFirstName()) + getInitial(person.getLastName());
}
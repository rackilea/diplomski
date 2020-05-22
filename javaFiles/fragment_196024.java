public int compare(Person p1, Person p2) {
    // TODO: Consider null checks, and what to do :)
    int firstNameResult = p1.getFirstName().compareTo(p2.getFirstName());
    if (firstNameResult != 0) {
        return firstNameResult;
    }
    int surnameResult = p1.getSurname().compareTo(p2.getSurname());
    if (surnameResult != 0) {
        return surnameResult;
    }
    return p1.getBirthDate().compareTo(p2.getBirthDate());
}
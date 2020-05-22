public boolean closeEnough(User other) {
    int count = 0;
    count += firstName.equals(other.firstName) ? 1 : 0;
    count += lastName.equals(other.lastName) ? 1 : 0;
    count += ssn.equals(other.ssn) ? 1 : 0;
    count += email.equals(other.email) ? 1 : 0;
    ...
    return count >= 3;
}
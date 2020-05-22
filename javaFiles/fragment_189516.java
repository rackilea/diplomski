@Override
public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof User)) {
        return false;
    }
    User user = (User) o;
    return id == user.id &&
            Objects.equals(firstName, user.firstName) &&
            Objects.equals(lastName, user.lastName) &&
            Objects.equals(userName, user.userName) &&
            Objects.equals(password, user.password);
}

@Override
public int hashCode() {
    return Objects.hash(id, firstName, lastName, userName, password);
}
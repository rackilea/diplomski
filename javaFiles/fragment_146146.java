@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;

    User user = (User) o;

    if (status != user.status) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
    if (language != null ? !language.equals(user.language) : user.language != null) return false;
    if (productCode != null ? !productCode.equals(user.productCode) : user.productCode != null) return false;

    return true;
}

@Override
public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (language != null ? language.hashCode() : 0);
    result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
    result = 31 * result + status;
    return result;
}
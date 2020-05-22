//IN THE AUTHOR CLASS PLACE THESE METHODS AND MODIFY FOR EXTRA FIELDS
@Override
public boolean equals(Object o) {

    if (o == this) return true;
    if (!(o instanceof Author)) {
        return false;
    }

    Author user = (Author) o;

    return user.firstName.equals(this.firstName) &&
           user.lastName.equals(this.lastName);
}

@Override
public int hashCode() {
    int result = 17;
    result = 31 * result + this.firstName.hashCode();
    result = 31 * result + this.lastName.hashCode();
    return result;
}
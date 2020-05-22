@Override
public int hashCode() {
    return (43 + 777);
}
@Override
public boolean equals(Object obj) {
    // checks to see whether the passed object is null, or if it’s typed as a 
    // different class. If it’s a different class then the objects are not equal.
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    // compares the objects’ fields.
    User user = (User) obj;
    return getName().contains(user.getName())
            && getBirthday() == user.getBirthday()
            && getAddress()== user.getAddress();
}
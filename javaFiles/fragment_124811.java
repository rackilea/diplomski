@Override
public boolean equals(Object object) {
    if(this == object) return true;
    if(!(object instanceof Name)) return false;

    Name other = (Name) object;
    boolean sameFirstName = firstName.equals(other.firstName);
    boolean sameMiddleName = middleName.equals(other.middleName);
    boolean sameLastName = lastName.equals(other.lastName);
    if (sameFirstName && sameMiddleName && sameLastName) {
        return true;
    }
    return false;
}
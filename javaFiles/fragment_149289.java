@Override
public boolean equals(Object obj) {
    if (this == obj)  // are the objects identical?
        return true;
    if (obj == null)  // is the other object null?
        return false;
    if (getClass() != obj.getClass()) // do the objects have the same class?
        return false;
    Test other = (Test) obj; // cast other object
    if (a != other.a) // is the `a` field equal in both objects?
        return false;
    if (b != other.b) // is the `b` field equal in both objects?
        return false;
    return true;      // ok, the objects are equal :)
}
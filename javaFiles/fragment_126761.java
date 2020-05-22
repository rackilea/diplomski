@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Employee other = (Employee) obj;
    if (employeeId == null) {
        if (other.employeeId != null)
            return false;
    } else if (!employeeId.equals(other.employeeId))
        return false;
    if (firstname == null) {
        if (other.firstname != null)
            return false;
    } else if (!firstname.equals(other.firstname))
        return false;
    if (Float.floatToIntBits(fte) == Float.floatToIntBits(other.fte))
        return false;
    if (lastname == null) {
        if (other.lastname != null)
            return false;
    } else if (!lastname.equals(other.lastname))
        return false;
    return true;
}
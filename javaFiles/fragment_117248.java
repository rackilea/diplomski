public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    YourClass other = (YourClass) obj;
    if (addressLine1 == null) {
        if (other.addressLine1 != null) return false;
    } else if (!addressLine1.equals(other.addressLine1)) return false;
    if (country == null) {
        if (other.country != null) return false;
    } else if (!country.equals(other.country)) return false;
    if (state == null) {
        if (other.state != null) return false;
    } else if (!state.equals(other.state)) return false;
    return true;
}
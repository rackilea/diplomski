@Override
public int hashCode() {
    int hash = 7;
    hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Author other = (Author) obj;
    if (this.id != other.id) {
        return false;
    }
    return true;
}
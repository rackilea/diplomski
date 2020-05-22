public int hashCode() {
    return Integer.hashCode(id);
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Obj other = (Obj) obj;
    if (id != other.id)
        return false;
    return true;
}
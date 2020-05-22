@Override
public boolean equals(Object obj) {
    if (obj == this)
        return true;
    if (!(obj instanceof MyEntityClass))
        return false;

    MyEntityClass other = (MyEntityClass) obj;
    return Objects.equals(getId(), other.getId());
}

@Override
public int hashCode() {
    return Objects.hash(getId());
}
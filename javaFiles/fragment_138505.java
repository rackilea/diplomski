@Override
public int hashCode() {
    return id.hashCode();
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (!(obj instanceof Item))
        return false;
    return ((Item) obj).id.equals(id);
}
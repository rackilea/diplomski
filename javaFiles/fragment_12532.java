public int hashCode() {
    return title.hashCode();
}

public boolean equals(Object obj) {
    if (!(obj instanceof Games)) {
        return false;
    }
    Games other = (Games)obj;
    return title.equals(other.title);
}
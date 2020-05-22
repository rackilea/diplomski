public int hashCode() {
    return nameOfStore.hashCode();
}

public boolean equals(Object obj) {
    if (!(obj instanceof LocalStores)) {
        return false;
    }
    LocalStores other = (LocalStores)obj;
    return nameOfStore.equals(other.nameOfStore);
}
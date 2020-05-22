@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if(this.id == null) {
        return false;
    }

    if (obj instanceof MyEntity && obj.getClass().equals(getClass())) {
        return this.id.equals(((MyEntity) obj).id);
    }

    return false;
}

@Override
public int hashCode() {
    int hash = 5;
    hash = 43 * hash + Objects.hashCode(this.id);
    return hash;
}
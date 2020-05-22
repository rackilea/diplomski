@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }

    Users that = (Users) o;

    return getId() == that.getId();
}

@Override
public int hashCode() {
    return Long.valueOf(getId()).hashCode();
}
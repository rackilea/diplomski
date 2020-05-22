@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    POJO pojo = (POJO) o;
    return Objects.equals(name, pojo.name);
}

@Override
public int hashCode() {
    return name.hashCode();
}
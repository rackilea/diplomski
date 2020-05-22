@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tuple tuple = (Tuple) o;
    return first == tuple.first &&
            second == tuple.second;
}

@Override
public int hashCode() {
    return Objects.hash(first, second);
}
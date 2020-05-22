@Override
public boolean equals(Object o) {
    if (!(o instanceof MyObject)) {
        return false;
    }

    MyObject m = (MyObject) o;

    return a.equals(m.a) && b.equals(m.b);
}

@Override
public int hashCode() {
    return Objects.hash(a, b);
}
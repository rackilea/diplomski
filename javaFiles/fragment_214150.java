@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof State)) return false;
    State state = (State) o;
    return a == state.a &&
            b == state.b &&
            c == state.c;
}

@Override
public int hashCode() {
    return Objects.hash(a, b, c);
}
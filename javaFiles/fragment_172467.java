@Override
public String toString() {
    return value != null
        ? String.format("Optional[%s]", value)
        : "Optional.empty";
}
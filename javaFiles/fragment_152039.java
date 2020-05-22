@Override
public Optional<T> first() {
    if (first != null) {
        return Optional.ofNullable(first.elem);
    }
    else {
        return Optional.empty();
    }
}
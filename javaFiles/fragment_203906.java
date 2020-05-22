@Override
public boolean setAll(Collection<? extends E> col) {
    beginChange();
    try {
        clear();
        addAll(col);
    } finally {
        endChange();
    }
    return true;
}
@Override
public boolean equals(Object o) {
    if (o == null) {
        return false;
    }
    if (!(o instanceof Line)) {
        return false;
    }
    return (beg == ((Line) o).beg && end == ((Line) o).end);
}
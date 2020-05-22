@Override
public int hashCode() {
    int h = 17;
    h = h * 31 + id == null ? 0 : id.hashCode();
    return h;
}
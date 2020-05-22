@Override
public boolean equals(Object o) {
    if (!(o instanceof IPAddress) {
        return false;
    }
    return Arrays.equals(asArray(), ((IPAddress) o).asArray());
}
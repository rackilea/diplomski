@Override
public boolean equals(Object o) {
    if (!(o instanceof Genre)) {
        return false;
    }
    return ((Genre) o).name.equals(this.name);
}
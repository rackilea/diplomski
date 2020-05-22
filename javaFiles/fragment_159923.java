@Override
public int compareTo(City other) {
    int r = this.name.compareTo(other.name);
    if (r != 0) {
        return r;
    } // the names are not the same, compare the states
    return this.state.compareTo(other.state);
}
public int compareTo(Cow other) {
    int compare = this.time - other.time;
    if(compare == 0) {
        compare = other.flower - this.flower;
    }
    return compare;
}
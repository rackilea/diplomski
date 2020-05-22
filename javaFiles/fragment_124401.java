public int compareTo(Unit other) {
    if (position != other.position) {
        if (position == 0) {
            return 1;
        } else if (other.position == 0) {
            return -1;
        }
        return Integer.compare(position, other.position);
    } else {
        return 0;
    }
}
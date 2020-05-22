public int compareTo(Ponto other) {
    if (this.x == other.x) {
        return (this.y < other.y) ? -1 : ((this.y == other.y) ? 0 : 1);
    } else {
        return (this.x < other.x) ? -1 : 1;
    }
}
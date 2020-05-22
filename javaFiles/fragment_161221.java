class Info implements Comparable<Info> {
    String nation;
    String names;
    double score;

    // more stuff ...

    public int compareTo(Info other) {
        return Double.compare(this.score, other.score);
    }
}
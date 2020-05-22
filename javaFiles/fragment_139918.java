public int compareTo(Student o) {
    int result = Integer.compare(this.getLevel(), o.getLevel());
    if (result == 0) {
        result = Integer.compare(this.getAverage(), o.getAverage());
    }
    return result;
}
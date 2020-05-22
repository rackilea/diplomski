public int compareTo(StudentIF other) {
        if (other == null) { return 1; } //satisfies your null student requirement
        if (this.studentId > other.studentId) return 1; 
        else if (this.studentId < other.studentId) return -1; 
        else return 0; //if it's neither smaller nor larger, it must be equal
}
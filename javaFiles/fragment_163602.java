public boolean equals(Domino d) {
    if (this.end1 == d.end1 && this.end2 == d.end2)
        return true;
    if (this.end2 == d.end1 && this.end1 == d.end2)
        return true;
    return false;
}
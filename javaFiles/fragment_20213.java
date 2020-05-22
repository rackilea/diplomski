public boolean equals(Object o) {
    if (o instanceof ComplexNum) {
        ComplexNum other = (ComplexNum)o;
        return (this.real == other.real) && (this.imag == other.imag);
    } else {
        return false;
    }
}
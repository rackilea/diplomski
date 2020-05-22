class Temp {
    // ...

    public boolean equals(Object obj) {
        Temp temp = (Temp)obj;
        return temp.x == this.x && temp.y == this.y;
    }

    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
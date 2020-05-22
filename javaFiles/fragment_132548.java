public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != Node.class) {
        return false;
    }
    Node other = (Node) obj;
    if (other.col != this.col) {
        return false;
    }
    if (other.row != this.row) {
        return false;
    }
    return true;
}

public int hashCode() {
    int result = 7;
    result += row * 31;
    result += col * 31;
    return result;
}
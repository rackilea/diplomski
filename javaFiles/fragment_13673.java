public int hashCode() {
    int result = 17;
    result = 37 * result + keyA.hashCode();
    result = 37 * result + keyB.hashCode();
    return result;
}

public boolean equals(Object another) { 
    return another.keyA.equals(keyA) && another.keyB.equals(keyB);
}
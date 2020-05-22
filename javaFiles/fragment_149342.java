public void addA() {
    synchronized( a ) {
        a++;
    }
}

public void addB() {
    synchronized( b ) {
        b++;
    }
}
class A {
    public int x;

    public void setX(int x) {
        if (x < 0) throw new IllegalArgumentException("x must be positive");
        this.x = x;
    } 
}
class Squares {
    int x,y;

    @Override
    public boolean equals(Object obj) {
        Squares s = (Squares)obj;
        return x==s.x && y==s.y;
    }

    @Override
    public int hashCode() {
        return 1000*y+x;
    }
}
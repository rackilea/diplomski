protected enum Size {
    XS, S, M, L, XL;
    static final Size[] VALUES = values();
    public Size incrementSize() { return VALUES[ordinal()+1]; }
    public Size decrementSize() { return VALUES[ordinal()-1]; }
}
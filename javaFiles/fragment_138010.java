protected enum Size {
    XS {
        public Size decrementSize() { throw new UnsupportedOperationException("No smaller size"); }
    }, 
    S, 
    M, 
    L, 
    XL {
        public Size incrementSize() { throw new UnsupportedOperationException("No larger size"); }
    };
    static final Size[] VALUES = values();
    public Size incrementSize() { return VALUES[ordinal()+1]; }
    public Size decrementSize() { return VALUES[ordinal()-1]; }
}
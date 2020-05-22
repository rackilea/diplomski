public G method() {
    switch(someVar) {
        case x:
            return new G1();
        case y:
            return new G2();
        default:
            // You can return null or a default instance of type G here as well.
            throw new UnsupportedOperationException("cases other than x or y are not supported.");
    }
 }
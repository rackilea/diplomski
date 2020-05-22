for (Point[] foo: settings.getAstroidForms()) {
    Point[] parr = new Point[foo.length];
    for (int i = 0; i < parr.length; i++) {
        parr[i] = new Point(foo[i]); // I assume here that you implemented correct copy constructor
    }
}
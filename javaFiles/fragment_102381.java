public static Rectangle union(Rectangle... rectangles) {
    Rectangle s = null;
    for (Rectangle r : rectangles) {
        if (s == null)
            s = r;
        else
            s = unionOfTwo(s, r);
    }
    return s;
}
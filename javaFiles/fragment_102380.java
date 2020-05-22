public static Rectangle union(Rectangle... rectangles) {
    Rectangle s = new Rectangle(0, 0, 0, 0); // <-- wrong
    if (rectangles.length != 0) {
        for (Rectangle r : rectangles) {
            s = unionOfTwo(s, r);
        }
        return s;
    } else {
        return null;
    }
}
boolean contains(Circle c) {
    Point p_rect_1 = {x, y};
    Point p_rect_2 = {x + width, y };
    Point p_rect_3 = {x + width, y + height };
    Point p_rect_4 = {x, y + height };
    Point[] points = new Point[] { p_rect_1, p_rect_2, p_rect_3, p_rect_4 };

    foreach(Point p : points) {
        // ** is raise to power
        if ((c.x - p.x)**2 + (c.y - p.y)**2 > c.r**2) {
            return false;
        }
    }
    return true;
}
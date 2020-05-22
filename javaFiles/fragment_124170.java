public void optimize() {
    if (vectors.size() < 3)
        return;

    for (int i = 2; i < vectors.size(); i++) {
        if (sameLine(vectors.get(i - 2),vectors.get(i - 1), vectors.get(i)))
            vectors.remove(--i);
    }
}

boolean sameLine(Point a, Point b , Point c) {
    if ((b.x < a.x && b.x < c.x)|| (b.x > c.x && b.x > a.x) || (b.y < a.y && b.y < c.y)|| (b.y > c.y && b.y > a.y))
        return false;
    return (a.y - b.y) * (a.x - c.x) == (a.y - c.y) * (a.x - b.x);
}
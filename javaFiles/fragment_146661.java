synchronized (location) {
    if(location.isEmpty()){
        return;
    }

    Point p = location.get(0);
    for (int i = 1; i < location.size(); i++) {
        Point q = location.get(i);
        g.drawLine(p.x, p.y, q.x, q.y);
        p = q;
    }
}
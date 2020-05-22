public Point getBestIntersectionPoint(double v1, Point p2, double v2, Point p3) {
        int diffX = p3.getX() - p2.getX();
        int diffY = p3.getY() - p2.getY();

        Point u = new Point(
                diffX == 0 ? 0 : diffX / Math.abs(diffX),
                diffY == 0 ? 0 : diffY / Math.abs(diffY));

        double p1x = getX();
        double p1y = getY();

        double p2x = p2.getX();
        double p2y = p2.getY();

        double a = v1 * v1 - v2 * v2 * (u.getX() * u.getX() + u.getY() * u.getY());
        double b = (v2 * (u.getX() * (2 * p1x - 2 * p2x) + u.getY() * (2 * p1y - 2 * p2y)));
        double c = -p2x * p2x - p2y * p2y - p1x * p1x - p1y * p1y + 2 * p2x * p1x + 2 * p2y * p1y;

        double temp = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double t1, t2; //This is now a double, too.
        t1 = (-b + temp) / (2 * a);
        t2 = (-b - temp) / (2 * a);

        Point s2_1 = new Point(
                (int) (t1 * v2 * u.getX() + p2x),
                (int) (t1 * v2 * u.getY() + p2y));
        Point s2_2 = new Point(
                (int) (t2 * v2 * u.getX() + p2x),
                (int) (t2 * v2 * u.getY() + p2y));

        Point ut1 = new Point((int) (s2_1.getX() - p2x), (int) (s2_1.getY() - p2y));
        ut1.setX(ut1.getX() / Math.abs(ut1.getX()));
        ut1.setY(ut1.getY() / Math.abs(ut1.getY()));

        Point ut2 = new Point((int) (s2_2.getX() - p2x), (int) (s2_2.getY() - p2y));
        ut2.setX(ut2.getX() / Math.abs(ut2.getX()));
        ut2.setY(ut2.getY() / Math.abs(ut2.getY()));

        return ut1.equals(u) ? s2_1 : ut2.equals(u) ? s2_2 : null;
    }
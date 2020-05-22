for (int yTemp = ymin; yTemp <= ymax; yTemp++) {
        ArrayList<Point> intersectionPoints = new ArrayList<>();

        for (int p = 0; p < edges.size() - 1; p++) {
            int x1, x2, y1, y2;
            double deltax, deltay, x;
            x1 = edges.get(p).x;
            y1 = edges.get(p).y;
            x2 = edges.get(p + 1).x;
            y2 = edges.get(p + 1).y;

            deltax = x2 - x1;
            deltay = y2 - y1;

            int roundedX;
            x = x1 + deltax / deltay * (yTemp - y1);
            roundedX = (int) Math.round(x);
            if ((y1 <= yTemp && y2 > yTemp) || (y2 <= yTemp && y1 > yTemp)) {
                intersectionPoints.add(new Point(roundedX, yTemp));
            }
        }
        //for the last interval
        int x1, x2, y1, y2;
        x1 = edges.get(edges.size() - 1).x;
        y1 = edges.get(edges.size() - 1).y;
        x2 = edges.get(0).x;
        y2 = edges.get(0).y;
        if ((y1 <= yTemp && y2 > yTemp) || (y2 <= yTemp && y1 > yTemp)) {
            intersectionPoints.add(new Point(x1 + (x2 - x1) / (y2 - y1) * yTemp - y1, yTemp));
        }
        //you have to sort the intersection points of every scanline from the lowest x value to thr highest
        Collections.sort(intersectionPoints, new SortXPoints());
        pointsOfScanline.add(intersectionPoints);
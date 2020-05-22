for (int xTemp = xmin; xTemp <= xmax; xTemp++) {
    System.out.println("Check: " + xTemp + ", " + yTemp);
    if (wasInside != this.contains(new Point(xTemp, yTemp))) {
        System.out.println(" - Inside! Bash!");
        intersectionPoints.add(new Point(xTemp, yTemp));
        wasInside = !wasInside;
    }
}
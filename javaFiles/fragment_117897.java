private void createPoints(Point clickedPoint, int clickedColor) {
    pointsToVisit.add(clickedPoint);

    while(!pointsToVisit.isEmpty()) {
        Point testPoint = pointsToVisit.poll();

        if(testPoint.x >= 0 && testPoint.x < image.getWidth() && testPoint.y >= 0 && testPoint.y < image.getHeight() 
            && image.getRGB(testPoint.x, testPoint.y) == clickedColor) {
            while(testPoint.x > 0 && image.getRGB(testPoint.x-1, testPoint.y) == clickedColor) {
                testPoint.x--;
            }
            currentLine = new Line(getColor(), 5);
            currentLine.addPoint(new Point(testPoint));

            pointsToVisit.add(new Point(testPoint.x, testPoint.y+1));
            pointsToVisit.add(new Point(testPoint.x, testPoint.y-1));

            image.setRGB(testPoint.x, testPoint.y, getColor().getRGB());

            while(testPoint.x < image.getWidth()-1 && image.getRGB(testPoint.x+1, testPoint.y) == clickedColor) {
                pointsToVisit.add(new Point(testPoint.x, testPoint.y+1));
                pointsToVisit.add(new Point(testPoint.x, testPoint.y-1));

                image.setRGB(testPoint.x, testPoint.y, getColor().getRGB());
                testPoint.x++;
            }
            currentLine.addPoint(new Point(testPoint));
            currentFill.addLine(currentLine);
        }
    }
}
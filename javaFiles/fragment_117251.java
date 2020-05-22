public class PolygonHelper {

    public Polygon makePolygon(List<Rectangle> rectangles){
        List<Point> points = calcPoints(rectangles);
        return new Polygon(points);
    }

    private List<Point> calcPoints(List<Rectangle> rectangles) {
        List<Point> ret = new ArrayList<>();

        List<Float> yCoords = new ArrayList<>(getAllYCoords(rectangles));
        yCoords.sort(Comparator.naturalOrder());

        float previousLeftCoord = 0;
        float previousRightCoord = 0;

        for(float yCoord : yCoords) {
            System.out.println("Considering yCoords "+ yCoord);
            float minimumXLeftCoord = minXLeftCoord(yCoord, rectangles);
            float maximumXRightCoord = maxXRightCoord(yCoord, rectangles);
            System.out.println("min X: "+minimumXLeftCoord);
            System.out.println("max X: "+maximumXRightCoord);

            if(yCoord == yCoords.get(0)) {
                ret.add(new Point(minimumXLeftCoord, yCoord));
                ret.add(new Point(maximumXRightCoord, yCoord));

            } else {

                if(minimumXLeftCoord!=previousLeftCoord) {
                    ret.add(0, new Point(previousLeftCoord, yCoord));
                    ret.add(0, new Point(minimumXLeftCoord, yCoord));
                } else {
                    ret.add(0, new Point(minimumXLeftCoord, yCoord));
                }

                if(maximumXRightCoord!=previousRightCoord) {
                    ret.add(new Point(previousRightCoord, yCoord));
                    ret.add(new Point(maximumXRightCoord, yCoord));
                } else {
                    ret.add(new Point(maximumXRightCoord, yCoord));
                }

            }

            previousLeftCoord = minimumXLeftCoord;
            previousRightCoord = maximumXRightCoord;
            System.out.println(ret);
        }

        return ret;

    }

    private Set<Float> getAllYCoords(List<Rectangle> rectangles) {
        List<Float> allBottomYCoords = rectangles.stream().map(rectangle -> rectangle.getBottom().getY()).collect(Collectors.toList());
        List<Float> allTopYCoords = rectangles.stream().map(rectangle -> rectangle.getTop().getY()).collect(Collectors.toList());

        Set<Float> allCoords = new HashSet<>();
        allCoords.addAll(allTopYCoords);
        allCoords.addAll(allBottomYCoords);
        return allCoords;
    }

    private float minXLeftCoord(Float y, List<Rectangle> rectangles) {
        return rectanglesAtY(y, rectangles).stream().map(rect -> rect.getLeft().getX()).min(Comparator.naturalOrder()).get();
    }

    private float maxXRightCoord(Float y, List<Rectangle> rectangles) {
        return rectanglesAtY(y, rectangles).stream().map(rect -> rect.getRight().getX()).max(Comparator.naturalOrder()).get();
    }

    private List<Rectangle> rectanglesAtY(Float y, List<Rectangle> rectangles) {
        List<Rectangle> rectsAtYExcBottomLines = rectsAtYExcBottomLines(y, rectangles);

        if(rectsAtYExcBottomLines.size()>0) {
            // there are rectangles that are not closing here, so ignore those that are closing.
            return rectsAtYExcBottomLines;
        } else {
            // there are only rectangle bottom lines so we need to consider them.
            return rectsAtYIncBottomLines(y, rectangles);
        }
    }

    private List<Rectangle> rectsAtYExcBottomLines(Float y, List<Rectangle> rectangles) {
        return rectangles.stream()
                .filter(rect -> rect.getTop().getY()<=y && rect.getBottom().getY()>y).collect(Collectors.toList());
    }

    private List<Rectangle> rectsAtYIncBottomLines(Float y, List<Rectangle> rectangles) {
        return rectangles.stream()
                .filter(rect -> rect.getTop().getY()<=y && rect.getBottom().getY()==y).collect(Collectors.toList());
    }

}
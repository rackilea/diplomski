List<Point> points = new ArrayList<Point>();
points.add(new Point(1, 2));
points.add(new Point(2, 2));
points.add(new Point(3, 4));
printCombinations(points);

public static void printCombinations(List<Point> points) {
    for (int i = 0; i < points.size(); i++) {
        for (int j = 0; j < points.size(); j++) {
            if (i != j)
                System.out.println(points.get(i) + ":" + points.get(j));
        }
    }
}
public boolean isHorizontalOrVertical(List<Point> points) {
    if (points == null || points.size() < 2) {
        throw new IllegalArgumentException("invalid number of points");
    }
    if (points.size() == 2) {
       return points.get(0).getFirstComponent() == points.get(1).getFirstComponent()
                || points.get(0).getSecondComponent() == points.get(1).getSecondComponent();
    } 
    Point start = points.get(0);
    return points.stream()
                .allMatch(p -> isHorizontalOrVertical(List.of(start, p)));
}
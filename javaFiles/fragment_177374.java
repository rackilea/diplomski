public List<String> getEqualPointList(Point point) {
    return this.points
               .entrySet()
               .stream()
               .filter(p -> p.getValue().isEqual(point))
               .map(e -> e.getKey())
               .collect(Collectors.toList());
}
public void readIfMatches(String line, String match, Function<Point, Object> factory) {
    if (line.contains(match)) {
        String info  = line.split(" ");
        int x = Integer.parseInt(info[1]);
        int y = Integer.parseInt(info[2]);
        globalList.add(factory.apply(new Point(x, y));
    }
}
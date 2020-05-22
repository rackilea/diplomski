public Point findStart() {
    Point location = new Point();
    for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
            if (map[i][j] == 's') {
                location.setLocation(i, j);
                break;
            }
        }
    }
    System.out.println(location.x + "," + location.y);
    return location;
}
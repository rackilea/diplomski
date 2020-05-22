class Coordinate {
    private int x, y;  // plus getter, setter, etc.

    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        else if (!(obj instanceof Coordinate))
            return false;

        Coordinate that = (Coordinate) obj;
        return this.x == that.x && this.y == that.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// ...

Map<Coordinate, Rectangle> coords = new HashMap<>();
for (int y = 0; y <= Map.getHeight(); y++) {
    for (int x = 0; x <= Map.getWidth(); x++) {
        Color color = Map.getColor(x, y);
        if (color.getBlue() == 255 && color.getRed() == 255 && color.getGreen() == 255) {
            Coordinate coordinate = new Coordinate(x, y);
            Rectangle rectangle = new Rectangle(x, y, 5, 5);
            coords.put(coordinate, rectangle);
        }
    }
}

for (Rectangle rectangle : coords.values()) {
    g.setColor(Color.red);
    g.draw(rect);
}
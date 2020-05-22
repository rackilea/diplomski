double[] points = new double[12];
for (int i = 0; i < 12; i += 2) {
    double angle = Math.PI * (0.5 + i / 6d);
    points[i] = Math.cos(angle);
    points[i + 1] = Math.sin(angle);
}
Polygon polygon = new Polygon(points);

OffsetPane op = new OffsetPane();

double fieldHeight = 100;
double fieldWidth = Math.sqrt(0.75) * fieldHeight;

for (int i = 0; i < 23; i++) {
    Button button = new Button();
    button.setShape(polygon);
    button.setPrefSize(fieldWidth, fieldHeight);
    op.getChildren().add(button);
}
// horizontal placement just right of the last element
op.setHPositionFunction((int index, double x, double y, double width, double height) -> new Point2D(x + width, y));

// vertical position half the size left/right depending on index and
// 1/4 the node height above the bottom of the last node
op.setVPositionFunction((int index, double x, double y, double width, double height) -> new Point2D(x + (index % 2 == 0 ? width : -width) / 2, y + height * 0.75));
@CascadeDeleteConnectedShapes
class Rectangle implements Shape {

}

class Line implements Shape, ShapeConnection {
    Rectangle from, to;

    public Line(Rectangle from, Rectangle to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Shape[] getConnectedShapes() {
        return new Shape[] { from, to };
    }
}
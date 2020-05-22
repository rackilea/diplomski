class Shape {
   private String property;
}
class Circle extends Shape {
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }        

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getRadius() {
        return this.radius;
    }
}


class ShapeArray {
    public ArrayList<Shape> shapeArray = new ArrayList<Shape>();

    public void addShapeToArray(Shape shape){
        shapeArray.add(shape);
    }
    public Shape getShape(int index) {
        return (Shape) this.shapeArray.get(index);
    }
}
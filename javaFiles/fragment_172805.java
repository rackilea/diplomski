public class ComplexShapeFactory extends ShapeFactory {
    public Shape getShape(int shapeTypeId){
        Shape shape = null;
        if(shapeTypeId == Const.SHAPE_HEXAGON) {
            shape = new Hexagon();//complex shape
        }
        else{
            // drop an error
        };
        return shape;
    }
}
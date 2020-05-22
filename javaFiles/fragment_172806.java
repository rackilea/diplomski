public class ShapeFactoryType {
    public static final int TYPE_SIMPLE = 1;
    public static final int TYPE_COMPLEX = 2;

    public ShapeFactory getShapeFactory(int type) {
        ShapeFactory sf = null;
        if(type == TYPE_SIMPLE) {
            sf = new SimpleShapeFactory();
        }
        else if (type == TYPE_COMPLEX) {
            sf = new ComplexShapeFactory();
        }
        else throw new BadShapeFactoryException("No factory!!");
        return sf;
    }
}
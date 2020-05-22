public class ShapeManipulator {

    public static void main(String[] args) {
        Shape s1 = new Shape();
        Shape s2 = new Shape();
        Shape s3 = new Shape();

        ShapeManipulationBase move = new MoveHandler();
        ShapeManipulationBase resize = new ResizeHandler();
        ShapeManipulationBase delete = new DeleteHandler();

        move.setXparam(50).setYparam(25).handle(s1);
        resize.setXparam(100).setYparam(250).handle(s1);
        resize.setXparam(200).setYparam(20).handle(s2);
        delete.handle(s3);
    }
}

//CoR basic interface 
interface ShapeManipulationHandler {
     void handle(Shape shape);
}

//base class allows swtting of optional x, y parameters 
abstract class ShapeManipulationBase implements ShapeManipulationHandler {

    protected int Xparam, Yparam; 

    //setters return this to allow chaining of setters 
    ShapeManipulationBase setXparam(int xparam) {
        Xparam = xparam;
        return this;
    }

    ShapeManipulationBase setYparam(int yparam) {
        Yparam = yparam;
        return this;
    }

    @Override
    public abstract void handle(Shape shape) ;
}

class MoveHandler extends ShapeManipulationBase {

    @Override
    public void handle(Shape shape) {
        System.out.println("Moving "+ shape + " by X="+ Xparam + " and Y="+ Yparam);
    }
}

class ResizeHandler extends ShapeManipulationBase {

    @Override
    public void handle(Shape shape) {
        System.out.println("Resizing "+ shape + " by X="+ Xparam + " and Y="+ Yparam);
    }
}

class DeleteHandler extends ShapeManipulationBase {

    @Override
    public void handle(Shape shape) {
        System.out.println("Deleting "+ shape);
    }
}

class Shape{
    private static int shapeCouner = 0;
    private final int shapeNumber;

    Shape() {
        shapeNumber = ++shapeCouner;
    }

    @Override
    public String toString() {
        return "Shape # "+shapeNumber;
    }
}
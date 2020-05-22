public interface IVisitableShape {
    void accept(IShapeVisitor v);
}

public interface IShapeVisitor {
    void visit(Line line);
    void visit(Rectangle rectangle);
}

public class Line extends Shape implements IVisitableShape {

    @Override
    public void accept(IShapeVisitor v) {
        v.visit(this);
    }
}

public class EditorImpl implements IShapeVisitor {
    public void visit(Line line) {
        //show the line editor
    }
    public void visit(Rectangle rect) {
        //show the rectangle editor
    }
}
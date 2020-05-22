public class SomeVisitor extends ParentVisitor {

    @Override
    public void visit(A a) {
        ...
    }

    @Override
    public void visit(InnerA a) {
        // Code that will, possibly, read and modify A.x
        ...
    }
public abstract class AbstractShape
{
    public abstract void print();

    public void sort(AbstractShape[] shapes) {
        // make your own implementation -> sort shapes
    }
}

public class Circle extends AbstractShape
{
    @Override public void print() {
        System.out.println("I'm a circle");
    }
}

public class Triangle extends AbstractShape
{
    @Override public void print() {
        System.out.println("I'm a triangle");
    }
}

public class Square extends AbstractShape
{
   @Override public void print() {
        System.out.println("I'm a square");
    }
}
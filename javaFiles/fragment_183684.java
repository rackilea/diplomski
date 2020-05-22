public class Triangle
{
    public Triangle() {
        System.out.println("Constructing triangle instance");
    }

    public void draw() {
        System.out.println("Drawing triangle instance");
    }
}

// using the class
Triangle t = new Triangle();
t.draw();
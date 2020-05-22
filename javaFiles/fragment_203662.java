public class TestPolymorph {
    public static void main(String[] args) {
        Shape drawObject = new Rectangle(40,60);
        drawObject.draw();

        drawObject = new Circle(40);
        drawObject.draw();
    }
}
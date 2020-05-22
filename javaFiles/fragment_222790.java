public class Cylinder extends Shape {
    private final float PI = 3.14159;
    private final float height;
    private final float radius;

    public Cylinder(float h, float r) {
        height = h;
        radius = r;
    }

    @Override
    double sa()
    {
        return 2*PI*radius*height;
    }

    @Override
    double vol()
    {
        return PI*radius*radius*height;
    }
}
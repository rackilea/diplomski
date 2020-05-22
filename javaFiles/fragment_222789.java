public class Cylinder extends Shape {
    private final float PI = 3.14159;

    @Override
    double sa(float h, float r)
    {
        return 2*PI*r*h;
    }

    @Override
    double vol(float h, float r)
    {
        return PI*r*r*h;
    }
}
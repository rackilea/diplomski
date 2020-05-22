public class CircleDescriber extends ShapeDescriber<Circle> {
    @Override
    public void describe(Circle circle) {
        super.describe(circle);
        System.out.println("Its radius is " + circle.getRadius());
    }
}
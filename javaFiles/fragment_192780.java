class Car {
    private static double r;

    public Car() {
        r = 0.0;
    }

    public Car(double rd) {
        r = rd;
    }

    public Car(Car Source){
        this.r = Source.getRadius();
    }

    public void setRadius (double r){
        this.r=r;
    }

    public double getRadius(){
        return this.r;
    }

    public double calCircumference(){
        return 2 * Math.PI * r;
    }

    public static double calArea() {
        return Math.PI * r * r;
    }
}

class CarApp {
    public static void main(String[] args)
    {

        Car car1 = new Car();
        Car car2 = new Car(car1);
        Car car3 = new Car(car2);

        double rd = Double.parseDouble(args[0]);
        System.out.println( "Car radius = " + rd );

        car1.setRadius(rd);
        // need define circle1 like `Circle circle1 = new Circle(...)`
        double cir = circle1.calCircumference();
        double area = circle1.calArea();

        car2.setRadius(rd);

        // need to define circle2, like the above
        double cir2 = circle2.calCircumference();
        double area2 = circle2.calArea();
        double radius2 = circle2.getRadius();


        car3.setRadius(rd);
        // need to define circle3, like the above above
        double cir3 = circle3.calCircumference();
        double area3 = circle3.calArea();
        double radius3 = circle3.getRadius();

        System.out.println("Before");
        System.out.println("Circumference for Car 1 = " + cir);
        System.out.println("Area for Car 1 = " + area);
        System.out.println("");
        System.out.println("Circumference for Car 2 = " + cir2);
        System.out.println("Area for Car 2 = " + area2);
        System.out.println("Radius for Car 2 = " + raduis2);
        System.out.println("");
        System.out.println("Circumference for Car 3 = " + cir3);
        System.out.println("Area for Car 3 = " + area3 );
        System.out.println("Radius for Car 3 = " + raduis3);

        car1.setRadius(22.0);
        double radius1 = car1.getRadius();
        cir = car1.calCircumference();
        area = car1.calArea();

        car2.setRadius(rd);
        double cir21 = car2.calCircumference();
        double area21 = car2.calArea();
        double radius21=car2.getRadius();

        car3.setRadius(10.0);
        double cir31 = car2.calCircumference();
        double area31 = car2.calArea();
        double radius31 = car2.getRadius();

        System.out.println("After");
        System.out.println("Radius for Car 1 = " + raduis1);
        System.out.println("");
        System.out.println("Circumference for Car 2 = " + cir21);
        System.out.println("Area for Car 2 = " + area21);
        System.out.println("Radius for Car 2 = " + raduis21);
        System.out.println("");
        System.out.println("Radius for Car 3 = " + raduis31);
    }
}
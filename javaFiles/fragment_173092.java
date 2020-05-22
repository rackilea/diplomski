public static void test(Rectangle a, Rectangle b) {
    System.out.println( a.intersects( b.getLayoutX(), b.getLayoutY(), b.getWidth(), b.getHeight()) );
    System.out.println( b.intersects( a.getLayoutX(), a.getLayoutY(), a.getWidth(), a.getHeight()) );
}

public static void print(String name, Rectangle r) {
    System.out.println(name + " : " + r.toString() + " layoutX: " + r.getLayoutX() + " layoutY: " + r.getLayoutY());
}

public static void main(String[] args) {
    Rectangle a = new Rectangle( 10.00, 10.00 );
    Rectangle b = new Rectangle( 30.00, 20.00 );

    //both at 0.00
    print("a", a);
    print("b", b);
    test(a, b); // true, true

    a.setLayoutX(100.00);
    a.setLayoutY(100.00);

    //only a at different position and not visually intersecting 
    print("a", a);
    print("b", b);
    test(a, b); // true, false

    b.setLayoutX( 73.00);
    b.setLayoutY(100.00);

    //Now b is set near a and intersects a visually 
    print("a", a);
    print("b", b);
    test(a, b); // false, false
}
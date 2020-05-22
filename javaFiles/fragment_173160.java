public static Shape createShape(String[] args) {
    Shape s = null;
    if(args.length > 0) {
        switch(args[0]) {
            case "Rectangle":
                if(args.length > 2) {
                    s = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                }
                break;
            case "Circle":
                if(args.length > 1) {
                    s = new Circle(Double.parseDouble(args[1]));
                }
                break;
            case "Triangle":
                //etc...
                break;
        }
    }
    return s;
}

public static void main(String[] args) {
    Shape s = createShape(args);

    if(s != null) {
        System.out.println("Area: " + s.area());
        System.out.println("Perimeter: " + s.perimeter());
    }
}
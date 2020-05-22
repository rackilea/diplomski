import java.util.Scanner;

public class AreaExcersice {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose 1 for circle or 2 for square:");
        int userInput = Integer.parseInt( input.nextLine() );

        TwoDimensionalShape twoDShape = null; 
        if (userInput == 1) {
            System.out.println("Enter a radius for circle:");
            int radius = Integer.parseInt( input.nextLine() );    

            twoDShape = new Circle("Blue", radius, radius, radius);
        } else if (userInput == 2) {
            System.out.println("Enter a length for the sides of the square");
            int side = Integer.parseInt( input.nextLine() );    

            twoDShape = new Rectange("Green", 0, 0, side, side);
        } else {
            System.out.println("Invalid input.");
        }

        if (twoDShape != null) {
            System.out.println( twoDShape.toString() );        
        }
    }

    public static abstract class Shape {
        String color;
        public Shape(String color) {
            this.color = color;
        }

        public abstract String toString();
    }

    public static abstract class TwoDimensionalShape extends Shape {
        int x;
        int y;
        public TwoDimensionalShape(String color, int x, int y) {
            super(color);
            this.x = x;
            this.y = y;
        }
        public abstract double getArea();
    }

    public static class Circle extends TwoDimensionalShape {
        int radius;
        public Circle(String color, int x, int y, int radius) {
            super(color, x, y);
            this.radius = radius;            
        }
        @Override
        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }
        @Override
        public String toString() {
            return color + " circle at " + x + ", " + y + " with radius " + 
                radius + " and area of " + getArea();
        }
    }

    public static class Rectange extends TwoDimensionalShape {
        int height;
        int width;
        public Rectange(String color, int x, int y, int height, int width) {
            super(color, x, y);
            this.height = height;
            this.width = width;
        }
        @Override
        public double getArea() {
            return width * height;
        }
        @Override
        public String toString() {
            return color + " rectange at " + x + ", " + y + " with height " + 
                height + ", width " + width + " and area of " + getArea();
        }
    }
}
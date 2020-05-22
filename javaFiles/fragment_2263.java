import java.util.Scanner;

public class ShapeDriver {

    public double cubeSide;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for cube, 2 for rectangular prism, 3 for cylinder, 4 for cone, or 5 for sphere.");
        int shapeNum = input.nextInt();

        if (shapeNum == 1) {
            ShapeDriver shDriver = new ShapeDriver();
            Cube cube = new Cube();
            System.out.println("Enter the length of a side of the cube.");
            shDriver.cubeSide = input.nextDouble();
            cube.setCubeLength(shDriver);

            System.out.println("Surface area: " + cube.surfaceArea());
            System.out.println("Volume: " + cube.volume());
        }
    }
}
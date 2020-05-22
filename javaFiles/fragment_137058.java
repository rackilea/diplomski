public class Point {

    public String name = "Henry";

    public Point() {

    }

    public Point(String name) {
        this.name = name; //changes current value (Henry) to the one sent as an argument.
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }


    public static void main(String[] args) {
        Point pointA = new Point();
        Point pointB = new Point("Other name");

        System.out.println(pointA.name); // Henry
        System.out.println(pointB.name); // Other name

        pointA.setName("New name");
        System.out.println(pointA.getName()); // New name
    }
}
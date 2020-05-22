public class TestGeom {
    public TestGeom() {
        Geom geom1 = new Geom();
        Geom geom2 = new Geom(1.0, 2.5, 3.1, "White");

        geom1.setDx(5.3);
        geom1.setDy(1.2);
        geom1.setDz(2.0);
        geom1.setColor("Red");

        System.out.println("Geom1 area: " + geom1.getArea());
        System.out.println("Geom2 volume: " + geom2.getVolume());
        System.out.println("Distance from geom1 to geom2: " + geom1.getDistanceTo(geom2));
    }

    public static void main(String[] args) {
        new TestGeom();
    }
}
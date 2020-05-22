public class Main {
        public static void main(String[] args){
        MultiDemPoint point1 = new MultiDemPoint(1,2,3,4);
        MultiDemPoint point2 = new MultiDemPoint(3);
        MultiDemPoint point3 = new MultiDemPoint(5.44444444,232323.12323,321321);
        System.out.println("Point1 coordinates:");
        point1.printCoords();

        System.out.println("Point2 coordinates:");
        point2.printCoords();

        System.out.println("Point3 coordinates:");
        point3.printCoords();

    }
}
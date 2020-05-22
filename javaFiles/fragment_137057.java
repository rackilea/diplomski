public class ParentPoint {
    public String name = "Parent Point";

    public ParentPoint() {
        // do something
    }
}

public class Point extends ParentPoint {

    public Point() {
        super();
        // do something else
    }

}
$ cat > Direction.java
public enum Direction {NORTH, EAST, SOUTH, WEST}
$ javac Direction.java 
$ javap Direction
Compiled from "Direction.java"
public final class Direction extends java.lang.Enum{
    public static final Direction NORTH;
    public static final Direction EAST;
    public static final Direction SOUTH;
    public static final Direction WEST;
    public static Direction[] values();
    public static Direction valueOf(java.lang.String);
    static {};
}
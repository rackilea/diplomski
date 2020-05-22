public enum Position {
    PITCHER, CATCHER, FIRST, SECOND, SHORT, THIRD, LEFT, CENTER, RIGHT
}

public class Player {
    private String name;
    private Position position;
    private int depth;  
    // be sure to properly override equals and hash code to eliminate duplicates  
}
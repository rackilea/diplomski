public interface Type {
}

public enum Wall implements Type {

    TOP_LEFT, TOP, TOP_RIGHT,
    LEFT, RIGHT,
    BOTTOM_LEFT, BOTTOM, BOTTOM_RIGHT,
    NORTH_EAST, NORTH_WEST,
    SOUTH_EAST, SOUTH_WEST
}

public enum Floor implements Type {

    TOP_LEFT,
    TOP
}
int directionFromStr(String str) {
    // Putting the string constant on the left side of the expression guards against null input
    if ("NORTH".equalsIgnoreCase(str)) return Exit.NORTH;
    if ("SOUTH".equalsIgnoreCase(str)) return Exit.SOUTH;
    if ("EAST".equalsIgnoreCase(str)) return Exit.EAST;
    if ("WEST".equalsIgnoreCase(str)) return Exit.WEST;

    // You could also return -1 or something like that
    throw new IllegalArgumentException("bad direction");
}
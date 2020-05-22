// Do not import anything

// This creates a Set that contains all posible values
// In case you need a subset use: EnumSet.of(WallEnums.RES, WallEnums.CAW, etc)
private static final Set<WallEnums> WALL_CODES = EnumSet.allOf(WallEnums.class);

// Later...
if (WALL_CODES.contains(someWallEnum)) {
    // Do stuff if someWallEnum belongs to WALL_CODES set
}
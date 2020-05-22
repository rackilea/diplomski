class Chunk {
    private Tile tiles[32][32];
    private Coordinate origin; // (0, 0) on this chunk's array is actually equal to origin on the map
    // Example: if the chunk started at (128, 128), then origin would be (128,128)
    ...
    public static Chunk loadChunk(...) { ... }
    ...
}
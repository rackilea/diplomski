class Map {
    public Chunk currentChunk;
    public ArrayList<Chunk> loadedChunks;
    ...
    public ArrayList<Chunk> getSurroundingChunks( Chunk ch ) {...}
    ...
}
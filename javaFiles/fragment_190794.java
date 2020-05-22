Map<Integer,Map<Integer,Chunk>> chunks = new HashMap<Integer,Map<Integer,Chunk>>();

private void setChunk(Integer x, Integer y, Chunk c) {
    if(chunks.get(x) == null) {
        chunks.put(x, new HashMap<Integer, Chunk>());
    }
    chunks.get(x).put(y, c);
}
private Chunk getChunk(Integer x, Integer y) {
    if(chunks.get(x) == null)
        return null;
    return chunks.get(x).get(y);
}
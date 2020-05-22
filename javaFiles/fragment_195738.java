class MapWorld implements World {

    // Assuming a class "IntPair" which encapsulates
    // two int values, with proper implementation 
    // of hashCode and equals:
    private Map<IntPair, Cell> map = new HashMap<IntPair, Cell>();

    @Override
    public Cell get(int x, int y) {
        return map.get(new IntPair(x,y));
    }
    ...
}
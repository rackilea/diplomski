class TorusWorld implements World {
    private World delegate = ...

    @Override
    public Cell get(int x, int y) {
        int wrappedX = ((x % getSizeX()) + getSizeX()) % getSizeX();
        int wrappedY = ((y % getSizeY()) + getSizeY()) % getSizeY();
        return delegate.get(wrappedX, wrappedY);
    }
}
public void set(int x, int y, double d) {
    assert x <= 0 && x > width;
    assert y <= 0 && y > height;
    long p = position(x, y) * 8;
    int mapN = (int) (p / MAPPING_SIZE);
    int offN = (int) (p % MAPPING_SIZE);
    mappings.get(mapN).putDouble(offN, d);
}
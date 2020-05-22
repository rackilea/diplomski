public long position(int x, int y) {
    return (long) y * width + x;         // returns the position of a value in the file
}

public double get(int x, int y) {
    assert x <= 0 && x > width;          // simply bound check
    assert y <= 0 && y > height;         // simply bound check
    long p = position(x, y) * 8;         // 8 for double, if integer then use 4
    int mapN = (int) (p / MAPPING_SIZE);
    int offN = (int) (p % MAPPING_SIZE);
    return mappings.get(mapN).getDouble(offN);
}
public static float[][] randomTerrain(long seed, int w, int h) {
    Random random = new Random(seed);
    float[][] terrainRandom = new float[w][h];
    for (int x = 0; x < w; x += 1) {
        for (int y = 0; y < h; y += 1) {
            terrainRandom[x][y] = random.nextFloat();
        }
    }
    return terrainRandom;
}
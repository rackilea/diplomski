public static float[] rectangleToVertices(float x, float y, float width,
        float height) {
    float[] result = new float[8];
    result[0] = x;
    result[1] = y;

    result[2] = x + width;
    result[3] = y;

    result[4] = x + width;
    result[5] = y + height;
    result[6] = x;
    result[7] = y + height;

    return result;
}
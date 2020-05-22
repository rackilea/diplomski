public static BufferedImage getNormalMap(Terrain terrain) {
    Vec3[] normals = terrain.getNormals();
    float[] pixels = new float[normals.length * 3];

    for (int i = 0; i < normals.length; i++) {
        Vec3 normal = normals[i];
        float x = (1.0f + normal.x) * 0.5f;
        float y = (1.0f + normal.y) * 0.5f;
        float z = (1.0f + normal.z) * 0.5f;
        pixels[i * 3] = x * MAX;
        pixels[i * 3 + 1] = y * MAX;
        pixels[i * 3 + 2] = z * MAX;
    }

    BufferedImage img = new BufferedImage(cols, rows, BufferedImage.TYPE_INT_RGB);
    WritableRaster imgRaster = img.getRaster();
    imgRaster.setPixels(0, 0, cols, rows, pixels);
    return img;
}
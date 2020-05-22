// Calculating normals from height map
public void calcNormals() {
    Vec3 up = new Vec3(0, 1, 0);
    float sizeFactor = 1.0f / (8.0f * cellSize);
    normals = new Vec3[rows * cols];

    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            Vec3 normal = up;

            if (col > 0 && row > 0 && col < cols - 1 && row < rows - 1) {
                float nw = getValue(row - 1, col - 1);
                float n = getValue(row - 1, col);
                float ne = getValue(row - 1, col + 1);
                float e = getValue(row, col + 1);
                float se = getValue(row + 1, col + 1);
                float s = getValue(row + 1, col);
                float sw = getValue(row + 1, col - 1);
                float w = getValue(row, col - 1);

                float dydx = ((ne + 2 * e + se) - (nw + 2 * w + sw)) * sizeFactor;
                float dydz = ((sw + 2 * s + se) - (nw + 2 * n + ne)) * sizeFactor;

                normal = new Vec3(-dydx, 1.0f, -dydz).getUnitVector();
            }

            normals[row * cols + col] = normal;
        }
    }
}
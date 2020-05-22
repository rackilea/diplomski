@Override
public void tick(float aTick) {
    float m01 = matrix.get(1);
    float m02 = matrix.get(2);
    float m04 = matrix.get(4);
    float m06 = matrix.get(6);
    float m08 = matrix.get(8);
    float m09 = matrix.get(9);
    float m12 = matrix.get(12);
    float m13 = matrix.get(13);
    float m14 = matrix.get(14);
    buffer.put(matrix);
    buffer.put(1, m04);
    buffer.put(2, m08);
    buffer.put(4, m01);
    buffer.put(6, m09);
    buffer.put(8, m02);
    buffer.put(9, m06);
    buffer.put(12, -(matrix.get(0) * m12 + m01 * m13 + m02 * m14));
    buffer.put(13, -(m04 * m12 + matrix.get(5) * m13 + m06 * m14));
    buffer.put(14, -(m08 * m12 + m09 * m13 + matrix.get(10) * m14));
    buffer.rewind();
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glLoadMatrix(buffer);
}
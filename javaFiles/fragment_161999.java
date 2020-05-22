float sum(CvMat mat) {
    final int rows = mat.rows();
    final int cols = mat.cols();
    final int step = mat.step()/4;
    FloatBuffer buf = mat.getFloatBuffer();
    float s = 0.0f;
    for (int row = 0; row < rows; row++) {
        buf.position(row * step);
        for (int col = 0; col< cols; col++) {
            s += buf.get();
        }
    }
    return s;
}
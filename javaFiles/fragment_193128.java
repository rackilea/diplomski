float bufferData[] = {
    1.0f, 1.0f, 0.75f, 1.0f,
    0.1f, 0.1f, 0.1f, 0.1f,
    0.25f,
    0.45f);
glBufferData(..., FloatBuffer.wrap(bufferData));
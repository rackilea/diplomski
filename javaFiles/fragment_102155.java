private float[] vertices = { // Vertices for a face
    -1.0f, -1.0f, 0.0f,  // 0. left-bottom-front
     1.0f, -1.0f, 0.0f,  // 1. right-bottom-front
    -1.0f,  1.0f, 0.0f,  // 2. left-top-front
     1.0f,  1.0f, 0.0f   // 3. right-top-front
};

for (int face = 0; face < 6; face++) {
    vertexBuffer.put(vertices);
}
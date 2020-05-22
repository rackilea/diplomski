float[] vertices = { // Vertices for a face
    -1.0f, -1.0f, -1.0f, 
     1.0f, -1.0f, -1.0f, 
    -1.0f,  1.0f, -1.0f, 
     1.0f,  1.0f, -1.0f  
    -1.0f, -1.0f,  1.0f, 
     1.0f, -1.0f,  1.0f, 
    -1.0f,  1.0f,  1.0f, 
     1.0f,  1.0f,  1.0f   
};

indices [] = {
    0, 1, 2, 3, // front
    4, 0, 6, 2, // left
    5, 4, 7, 6, // back
    1, 5, 3, 7, // right
    2, 3, 6, 7, // top   
    4, 5, 0, 1  // bottom
}

for (int i = 0; i < 24; i++) {
   int vi = indices[i]*3;
   vertexBuffer.put(vertices[vi + 0]);
   vertexBuffer.put(vertices[vi + 1]);
   vertexBuffer.put(vertices[vi + 2]);
}
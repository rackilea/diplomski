// You have to use LWJGL3's way of memory management which is off-heap
// more info: https://blog.lwjgl.org/memory-management-in-lwjgl-3/
try(MemoryStack stack = MemoryStack.stackPush()){

    FloatBuffer dataBuffer = stack.mallocFloat(data.length);
    dataBuffer.put(data);
    dataBuffer.flip();

    indicesCount = indices.length; // Store for later use ( needed for rendering )
    ByteBuffer indicesBuffer = stack.malloc(indicesCount);
    indicesBuffer.put(indices);
    indicesBuffer.flip();

    vaoId = glGenVertexArrays();
    glBindVertexArray(vaoId);

    vboId = glGenBuffers();
    glBindBuffer(GL_ARRAY_BUFFER, vboId);
    glBufferData(GL_ARRAY_BUFFER, dataBuffer, GL_STATIC_DRAW);

    // Vectors
    int program_in_position = glGetAttribLocation(program, "position");
    glEnableVertexAttribArray(program_in_position);
    glVertexAttribPointer(program_in_position, 3, GL_FLOAT, false, 6*(Float.SIZE / Byte.SIZE), alreadyTakenBytes);

    // Colors
    int colorAttPos= glGetAttribLocation(program, "color");
    glEnableVertexAttribArray(colorAttPos);
    glVertexAttribPointer(colorAttPos, 3, GL_FLOAT, false, 6*(Float.SIZE / Byte.SIZE), 3*(Float.SIZE / Byte.SIZE));

    glBindBuffer(GL_ARRAY_BUFFER, 0);
    glBindVertexArray(0);

    // Now the Index VBO
    indexVBO = glGenBuffers();
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexVBO);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
}
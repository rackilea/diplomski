vao = glGenVertexArrays();
glBindVertexArray(vao);

vboID = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vboID);
glBufferData(GL_ARRAY_BUFFER, vertBuff, GL_STATIC_DRAW);
GL20.glVertexPointer(3, GL_FLOAT, 0, 0);  // <--------------
glBindBuffer(GL_ARRAY_BUFFER, 0);
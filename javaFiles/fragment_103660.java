vao = glGenVertexArrays();
glBindVertexArray(vao);

vboID = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vboID);
glBufferData(GL_ARRAY_BUFFER, vertBuff, GL_STATIC_DRAW);
GL20.glVertexPointer(3, GL_FLOAT, 0, 0);    // <--------------
glEnableClientState( GL_VERTEX_ARRAY );     // <--------------
glBindBuffer(GL_ARRAY_BUFFER, 0);

ibo = glGenBuffers();
glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuff, GL_STATIC_DRAW);
// skip glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
glBindVertexArray(0);
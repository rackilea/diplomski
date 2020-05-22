vaoId = glGenVertexArrays();
glBindVertexArray(vaoId);

vboId = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vboId);
glBufferData(GL_ARRAY_BUFFER, vertBuf, GL_STATIC_DRAW);

glVertexPointer( 2, GL_FLOAT, 0, 0 ); 
glEnableClientState( GL_VERTEX_ARRAY ); // <---------------

glBindBuffer(GL_ARRAY_BUFFER, 0);
glBindVertexArray(0);
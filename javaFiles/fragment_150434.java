int vertices = 6;

int vertex_size = 3; // X, Y, Z,
int texture_size = 2; // U, V,

FloatBuffer vertex_data = BufferUtils.createFloatBuffer(vertices * vertex_size);
vertex_data.put(new float[] { -1f, 1f, 0f, }); // Vertex
vertex_data.put(new float[] { 1f, 1f, 0f, }); // Vertex
vertex_data.put(new float[] { -1f, -1f, 0f, }); // Vertex

vertex_data.put(new float[] { 1f, -1f, 0f, }); // Vertex
vertex_data.put(new float[] { -1f, -1f, 0f, }); // Vertex
vertex_data.put(new float[] { 1f, 1f, 0f, }); // Vertex

FloatBuffer texture_data = BufferUtils.createFloatBuffer(vertices * texture_size);
texture_data.put(new float[] { 0f, 1f, }); // Texture Coordinate
texture_data.put(new float[] { 1f, 1f, }); // Texture Coordinate
texture_data.put(new float[] { 0f, 0f, }); // Texture Coordinate

texture_data.put(new float[] { 1f, 0f, }); // Texture Coordinate
texture_data.put(new float[] { 0f, 0f, }); // Texture Coordinate
texture_data.put(new float[] { 1f, 1f, }); // Texture Coordinate

vertex_data.flip();
texture_data.flip();

int vbo_vertex_handle = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
glBufferData(GL_ARRAY_BUFFER, vertex_data, GL_STATIC_DRAW);
glBindBuffer(GL_ARRAY_BUFFER, 0);

int vbo_texture_handle = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vbo_texture_handle);
glBufferData(GL_ARRAY_BUFFER, texture_data, GL_STATIC_DRAW);
glBindBuffer(GL_ARRAY_BUFFER, 0);
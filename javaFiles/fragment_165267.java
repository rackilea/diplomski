// This needs to happen only ONCE ( position stays the same )
int uniModel = glGetUniformLocation(program, "model");

// Create a Matrix
Matrix4f model = Matrix4f.translate(0, 0, -10);

// Create Float Buffer from Matrix4f
FloatBuffer fb = model.toBuffer();

// Push FloatBuffer to Shader
glUniformMatrix4fv(uniModel, false, fb);
public Vector2f get2DFrom3D(float x, float y, float z)
{
    FloatBuffer screen_coords = BufferUtils.createFloatBuffer(4);
    IntBuffer viewport = BufferUtils.createIntBuffer(16);
    FloatBuffer modelview = BufferUtils.createFloatBuffer(16);  
    FloatBuffer projection = BufferUtils.createFloatBuffer(16);

    Matrix4f modelviewMatrix = new Matrix4f();
    Matrix4f transformationMatrix = new Matrix4f();
    Matrix4f.mul(transformationMatrix
            , Maths.createViewMatrix(camera)
            , modelviewMatrix);

    modelviewMatrix.store(modelview);
    modelview.rewind();

    projectionMatrix.store(projection);
    projection.rewind();

    GL11.glGetInteger(GL11.GL_VIEWPORT, viewport);

    boolean result = GLU.gluProject(x, y, z, modelview, projection, viewport, screen_coords);

    if (result)
    {
        Vector2f vector = new Vector2f((int)screen_coords.get(0), (int)(screen_coords.get(1)));
        return vector;
    }
    else
    {
        return null;
    }
}
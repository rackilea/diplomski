public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
    tex.bind();
    glEnable(GL_TEXTURE_2D);
    ...
    glDisable(GL_TEXTURE_2D);
}
public void renderModel(int index) {
    Model model = Editor.models.get(index);
    glMatrixMode(GL_MODELVIEW);

    // apply rotation
    float rotation = 90f;

    glTranslate(x, -z4, y);
    glRotate(rotation, 0, 1, 0);

    for (int triangle = 0; triangle < model.face_cnt; triangle++) {
        if (model.face_verts.get(triangle).length == 3) {
            glBegin(GL_TRIANGLES);
        } else {
            glBegin(GL_QUADS);
        }
        for (int i = 0; i < model.face_verts.get(triangle).length; i++) {
                int point_a = model.face_verts.get(triangle)[i];

                float modelX = (float)((model.vert_x.get(point_a)));
                float modelZ = (float)((model.vert_y.get(point_a)));
                float modelY = (float)((model.vert_z.get(point_a)));

                glVertex3f(modelX, -modelZ, -modelY); // draw
        }
        glEnd();
    }
}
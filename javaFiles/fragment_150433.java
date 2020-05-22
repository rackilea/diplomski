texture.bind();

glBegin(GL_TRIANGLES);

    glTexCoord2f(0f, 1f);
    glVertex3f(-1f, 1f, 0f);
    glTexCoord2f(1f, 1f);
    glVertex3f(1f, 1f, 0f);
    glTexCoord2f(0f, 0f);
    glVertex3f(-1f, -1f, 0f);

    glTexCoord2f(1f, 0f);
    glVertex3f(1f, -1f, 0f);
    glTexCoord2f(0f, 0f);
    glVertex3f(-1f, -1f, 0f);
    glTexCoord2f(1f, 1f);
    glVertex3f(1f, 1f, 0f);

glEnd();

texture.unbind();
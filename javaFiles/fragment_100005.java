public static void quadPrizm(float x, float y, float z, float sx, float sy, float sz, Texture tex){
glPushMatrix();
{
    glTranslatef(x, y, z);

    tex.bind();
    glBegin(GL_QUADS);
    {
        //ROTATED (WRONG)
        glTexCoord2f(4, 0); glVertex3f(-sx/2, -sy/2, sz/2);
        glTexCoord2f(0, 0); glVertex3f(sx/2, -sy/2, sz/2);
        glTexCoord2f(0, 4); glVertex3f(sx/2, sy/2, sz/2);
        glTexCoord2f(4, 4); glVertex3f(-sx/2, sy/2, sz/2);

        //THE CORRECT SIDE
        glTexCoord2f(0, 0); glVertex3f(-sx/2, -sy/2, -sz/2);
        glTexCoord2f(0, 4); glVertex3f(-sx/2, sy/2, -sz/2);
        glTexCoord2f(4, 4); glVertex3f(sx/2, sy/2, -sz/2);
        glTexCoord2f(4, 0); glVertex3f(sx/2, -sy/2, -sz/2);

        //ROTATED (WRONG)
        glTexCoord2f(4, 0); glVertex3f(-sx/2, -sy/2, -sz/2);
        glTexCoord2f(0, 0); glVertex3f(-sx/2, -sy/2, sz/2);
        glTexCoord2f(0, 4); glVertex3f(-sx/2, sy/2, sz/2);
        glTexCoord2f(4, 4); glVertex3f(-sx/2, sy/2, -sz/2);

        //ROTATED (WRONG)
        glTexCoord2f(4, 0); glVertex3f(sx/2, -sy/2, -sz/2);
        glTexCoord2f(0, 0); glVertex3f(sx/2, -sy/2, sz/2);
        glTexCoord2f(0, 4); glVertex3f(sx/2, sy/2, sz/2);
        glTexCoord2f(4, 4); glVertex3f(sx/2, sy/2, -sz/2);

        //BOTTOM SIDE
        glTexCoord2f(0, 0); glVertex3f(-sx/2, -sy/2, -sz/2);
        glTexCoord2f(0, 4); glVertex3f(sx/2, -sy/2, -sz/2);
        glTexCoord2f(4, 4); glVertex3f(sx/2, -sy/2, sz/2);
        glTexCoord2f(4, 0); glVertex3f(-sx/2, -sy/2, sz/2);

        //TOP SIDE
        glTexCoord2f(0, 0); glVertex3f(-sx/2, sy/2, -sz/2);
        glTexCoord2f(0, 4); glVertex3f(sx/2, sy/2, -sz/2);
        glTexCoord2f(4, 4); glVertex3f(sx/2, sy/2, sz/2);
        glTexCoord2f(4, 0); glVertex3f(-sx/2, sy/2, sz/2);
        }
        glEnd();
    }
    glPopMatrix();
}
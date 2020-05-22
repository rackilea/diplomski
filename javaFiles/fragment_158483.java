// Render a wall
            glTexCoord2f(0, 0);
            glNormal3f(wall.a.x > 0 ? 1 : -1, wall.a.y > 0 ? 1 : -1, wall.a.z > 0 ? 1 : -1);
            glVertex3f(wall.a.x, wall.a.y, wall.a.z);
            glTexCoord2f(xS, 0);
            glNormal3f(wall.b.x > 0 ? 1 : -1, wall.b.y > 0 ? 1 : -1, wall.b.z > 0 ? 1 : -1);
            glVertex3f(wall.b.x, wall.b.y, wall.b.z);
            glTexCoord2f(xS, yS);
            glNormal3f(wall.c.x > 0 ? 1 : -1, wall.c.y > 0 ? 1 : -1, wall.c.z > 0 ? 1 : -1);
            glVertex3f(wall.c.x, wall.c.y, wall.c.z);
            glTexCoord2f(0, yS);
            glNormal3f(wall.d.x > 0 ? 1 : -1, wall.d.y > 0 ? 1 : -1, wall.d.z > 0 ? 1 : -1);
            glVertex3f(wall.d.x, wall.d.y, wall.d.z);
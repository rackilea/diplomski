public static void rect(float x, float y, float width, float height, Texture tex) {
        glEnable(GL_TEXTURE_2D);
        glTranslatef(x, y, 0);        
        glColor4f(1f, 1f, 1f, 1f); //NEEDS to be white before drawing, else stuff will tint.
        tex.bind();
        glBegin(GL_QUADS); //Specifies to the program where the drawing code begins. just to keep stuff neat. GL_QUADS specifies the type of shape you're going to be drawing.
        {
            //PNG format for images
            glTexCoord2f(0,1); glVertex2f(0, 0);  //Specify the vertices. 0, 0 is on BOTTOM LEFT CORNER OF SCREEN.
            glTexCoord2f(0,0); glVertex2f(0, height); //2f specifies the number of args we're taking(2) and the type (float)
            glTexCoord2f(1,0); glVertex2f(width, height); 
            glTexCoord2f(1,1); glVertex2f(width, 0);
        }
        glEnd();
        glDisable(GL_TEXTURE_2D);
    }
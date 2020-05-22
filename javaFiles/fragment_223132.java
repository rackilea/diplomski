glPushAttrib(GL_ENABLE_BIT);
    glLoadIdentity();

    glDisableClientState(GL_VERTEX_ARRAY);
    glDisableClientState(GL_NORMAL_ARRAY);
    glBindBuffer(GL_ARRAY_BUFFER, 0);
    glMatrixMode(GL_PROJECTION);
    glLoadMatrix(orthographicProjectionMatrix);
    glMatrixMode(GL_MODELVIEW);
    glPushMatrix();
    glLoadIdentity();
    glDisable(GL_LIGHTING);

    width = Display.getWidth()/2;
    height = Display.getHeight()/2;
    int ch = Display.getHeight()/10;
   // int locationY = 100;
    //if (true) return;
    //if (true) return;

    glDisable(GL_TEXTURE_2D);

        String msg = loadMessage;

        if (false){ //If statements are here, but are irrelevant to fixing the issue
        }else{
            int offset = font.getWidth(msg)/2;
         font.drawString(Display.getWidth()/2 - offset, Display.getHeight()/2, msg, Color.magenta);
         glPopMatrix();
         glPopAttrib();
         System.out.println("Error: " + glGetError());
         glGetError();
         if (true) return;
        }
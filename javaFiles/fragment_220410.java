gl.glMatrixMode(GL.GL_PROJECTION);                                        
gl.glPushMatrix();                                                 
gl.glLoadIdentity();                                               
gl.glMatrixMode(GL.GL_MODELVIEW);                                  
gl.glPushMatrix();                                                 
gl.glLoadIdentity();

gl.glBindTexture(GL.GL_TEXTURE_2D, ib.get(0));  //Retrieved from your object
gl.glEnable(GL.GL_TEXTURE_2D);
gl.glTexSubImage2D(GL.GL_TEXTURE_2D, 0, 0, 0, width, height, 0, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, buff);

gl.glBegin(GL.GL_QUADS);
    gl.glTexCoord2f(0,1);
    gl.glVertex2f(-1, -1); 
    gl.glTexCoord2f(0, 0);
    gl.glVertex2f(-1, 1);
    gl.glTexCoord2f(1, 0);   
    gl.glVertex2f(1, 1);
    gl.glTexCoord2f(1, 1);      
    gl.glVertex2f(1, -1);
gl.glEnd();

gl.glMatrixMode(GL.GL_MODELVIEW);                                  
gl.glPopMatrix();   
gl.glMatrixMode(GL.GL_PROJECTION);                                        
gl.glPopMatrix();   
gl.glMatrixMode(GL.GL_MODELVIEW);
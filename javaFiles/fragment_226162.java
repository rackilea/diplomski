FloatBuffer grabScreen(GL gl) 
{       
    int w = SCREENWITDH;
    int h = SCREENHEIGHT;
    FloatBuffer bufor = FloatBuffer.allocate(w*h*4); // 4 = rgba

    gl.glReadBuffer(GL.GL_FRONT);
    gl.glReadPixels(0, 0, w, h, GL.GL_RGBA, GL.GL_FLOAT, bufor); //Copy the image to the array imageData

    return bufor;
}
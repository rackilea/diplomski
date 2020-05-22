GL11.glMatrixMode   (GL11.GL_PROJECTION);
GL11.glLoadIdentity ();
GL11.glOrtho        (0, width, height, 0, -1, 1);

GL11.glMatrixMode   (GL11.GL_MODELVIEW);
GL11.glLoadIdentity ();
GL11.glTexCoord2d(0d, 0d);
GL11.glVertex3d(xIn, height1, zIn);

GL11.glTexCoord2d(1d, 0d);
GL11.glVertex3d(xOut, height2, zIn);

GL11.glTexCoord2d(1d, 1d);
GL11.glVertex3d(xOut, height3, zOut);

GL11.glTexCoord2d(0d, 1d);
GL11.glVertex3d(xIn, height4, zOut);
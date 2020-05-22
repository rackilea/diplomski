GL11.glPushMatrix();
    GL11.glTranslatef(x, y, z);
    GL11.glRotatef(180 - rotation.y, 0.0f, 1.0f, 0.0f);
    GL11.glTranslatef(-x, -y, -z);

    GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, fontTextureID);
    GL11.glBegin(GL11.GL_QUADS);
    for(QuadObject quad : list) {
        drawQuad(quad.drawX, quad.drawY, quad.drawX2, quad.drawY2, quad.srcX, quad.srcY, quad.srcX2, quad.srcY2, quad.z);
    }
    GL11.glDisable(GL11.GL_TEXTURE_2D);
    GL11.glEnd();
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);

    GL11.glPopMatrix();
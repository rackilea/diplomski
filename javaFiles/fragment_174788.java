GL11.glTexCoord2f(0.0, 0.0);
GL11.glVertex2f(n.getPosition().x * 40 + 3, n.getPosition().y * 40 + 3);
GL11.glTexCoord2f(0.0, 1.0);
GL11.glVertex2f(n.getPosition().x * 40 + 3, n.getPosition().y * 40 + 37);
GL11.glTexCoord2f(1.0, 1.0);
GL11.glVertex2f(n.getPosition().x * 40 + 37, n.getPosition().y * 40 + 37);
GL11.glTexCoord2f(1.0, 0.0);
GL11.glVertex2f(n.getPosition().x * 40 + 37, n.getPosition().y * 40 + 3);
public static void renderLightmap(Graphics g)
{
    GL11.glEnable(GL11.GL_BLEND);
    GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_ONE_MINUS_SRC_ALPHA);
    g.drawImage(lightmap, 0, 0);
    GL11.glDisable(GL11.GL_BLEND);
    g.setDrawMode(Graphics.MODE_NORMAL);
}
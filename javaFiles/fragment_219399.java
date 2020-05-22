public void render()
{
    Object1.render( 5, 0, 5);
    Object1.render(-5, 0,-5);
    Object2.render( 5, 0,-5);
    Object2.render(-5, 0, 5);
    GL11.glEnd();
}
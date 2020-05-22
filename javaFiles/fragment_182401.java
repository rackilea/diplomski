public void doTransformAndDraw(int x, int y)
{
    AffineTransform transform = new AffineTransform();
    //transform.scale(-1, 1);
    transform.translate(-sprite.getWidth(), 0);
    g.drawImage(sprite, x, y, null);
}
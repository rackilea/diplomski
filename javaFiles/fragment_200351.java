class Bullet
{
  private double dx, dy;
  private int x, y;
  ....

  public void update()
  {
    x += dx;
    y += dy;
    System.out.println("dx : " + dx + "  " + dy);
  }
  ...
}
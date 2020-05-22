public Point rotate(int x, int y, double angle)
{
    // Do rotation.
    return new Point(newX, newY);
}

public void callingMethod()
{
    int x = 10;
    int y = 10;
    p = rotate(x, y, 45);
    System.out.println(x);  // Should print something other than 10.
    System.out.println(y);  // Should print something other than 10.
}
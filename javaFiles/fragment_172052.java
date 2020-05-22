ArrayList<Point> balls = new ArrayList<Point>(5); // instance variable

AllBalls()
{
    Random r = new Random();

    for (int i = 0; i < 5; i++)
        balls.add( new Point(r.nextInt(320), r.nextInt(550));
}
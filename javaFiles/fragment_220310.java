public ConvexHull(int n) throws IllegalArgumentException 
{

    if (n < 1)
        throw new IllegalArgumentException();
    else {
        points=new Points[n];  //this is the line that is added

        Random rand = new Random();

        for (int i=0; i<n; i++)
        {
            int x = rand.nextInt(101)-50;
            int y = rand.nextInt(101)-50;
            Point p = new Point(x,y);
            this.points[i] = p;      // NullPointerException is thrown.
            this.numPoints = points.length;
        }
    }
}
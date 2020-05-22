public class SomeJavaClassName 
{ 
    ArrayList<Vec2D> points = new ArrayList<String>();

    // Other methods, properties, variables, etc.,
    // some of which would populate points

    public Vec2D getCasteljauPoint(int r, int i, double t) { 
        // points[] is declared outside just like in the C# code
        if(r == 0) return points.get(i);

        Vec2D p1 = getCasteljauPoint(r - 1, i, t);
        Vec2D p2 = getCasteljauPoint(r - 1, i + 1, t);

        return new Vec2D(((1/2) * p1.getX + (1/2) * p2.getX), ((1/2)
                            * p1.getY + (1/2) * p2.getY));
    }
}
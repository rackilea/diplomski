import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Random;


public class ExtractRotation
{
    public static void main(String[] args)
    {
        for (int i=0; i<=180; i++)
        {
            double angleRad = Math.toRadians(i);
            AffineTransform at = createRandomTransform(angleRad);
            double extractedAngleRad = extractAngle(at);
            System.out.println(
                "In: "+Math.toDegrees(angleRad)+ " " +
                "Out "+Math.toDegrees(extractedAngleRad));
        }
    }

    private static double extractAngle(double m[])
    {
        return extractAngle(new AffineTransform(m));
    }
    private static double extractAngle(AffineTransform at)
    {
        Point2D p0 = new Point();
        Point2D p1 = new Point(1,0);
        Point2D pp0 = at.transform(p0, null);
        Point2D pp1 = at.transform(p1, null);
        double dx = pp1.getX() - pp0.getX();
        double dy = pp1.getY() - pp0.getY();
        double angle = Math.atan2(dy, dx);
        return angle;
    }

    private static Random random = new Random(0); 
    private static AffineTransform createRandomTransform(double angleRad)
    {
        AffineTransform at = new AffineTransform();
        double scale = 1.0;
        at.translate(randomDouble(), randomDouble());
        scale = Math.abs(randomDouble());
        at.scale(scale, scale);
        at.rotate(angleRad);
        at.translate(randomDouble(), randomDouble());
        scale = Math.abs(randomDouble());
        at.scale(scale, scale);
        return at;
    }

    private static double randomDouble()
    {
        return -5.0 + random.nextDouble() * 10;
    }


}
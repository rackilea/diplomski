public class PlaneIsBetweePoints
{
    public static void main(String[] args)
    {
        System.out.println(planeIsBetweenPoints(
            5,5,-5, 
            5,5, 5, 
            0,10,0, 
            10,10,0, 
            10,0,0, 
            0,0,0));
        System.out.println(planeIsBetweenPoints(
            5,5, 5, 
            5,5,-5, 
            0,10,0, 
            10,10,0, 
            10,0,0, 
            0,0,0));
        System.out.println(planeIsBetweenPoints(
            5,5, 5, 
            5,5,10, 
            0,10,0, 
            10,10,0, 
            10,0,0, 
            0,0,0));
        System.out.println(planeIsBetweenPoints(
            5,5,-10, 
            5,5,-5, 
            0,10,0, 
            10,10,0, 
            10,0,0, 
            0,0,0));
    }


    public static boolean planeIsBetweenPoints(
        int p0x, int p0y, int p0z, 
        int p1x, int p1y, int p1z, 
        int v0x, int v0y, int v0z, 
        int v1x, int v1y, int v1z, 
        int v2x, int v2y, int v2z, 
        int v3x, int v3y, int v3z)
    {
        double p0[] = { p0x, p0y, p0z };
        double p1[] = { p1x, p1y, p1z };
        double v0[] = { v0x, v0y, v0z };
        double v1[] = { v1x, v1y, v1z };
        double v2[] = { v2x, v2y, v2z };
        double v3[] = { v3x, v3y, v3z };

        return 
            lineSegmentTriangleIntersection(p0, p1, v0, v1, v2) ||
            lineSegmentTriangleIntersection(p0, p1, v0, v2, v3);
    }

    private static final double EPSILON = 0.000001;
    private static void CROSS(double result[], double v0[], double v1[])
    {
        result[0] = v0[1] * v1[2] - v0[2] * v1[1];
        result[1] = v0[2] * v1[0] - v0[0] * v1[2];
        result[2] = v0[0] * v1[1] - v0[1] * v1[0];
    }

    private static double DOT(double v0[], double v1[])
    {
        return v0[0] * v1[0] + v0[1] * v1[1] + v0[2] * v1[2]; 
    }

    private static void SUB(double result[], double v0[], double v1[])
    {
        result[0] = v0[0] - v1[0];
        result[1] = v0[1] - v1[1];
        result[2] = v0[2] - v1[2];
    }

    private static void SCALE(double result[], double v[], double f)
    {
        result[0] = v[0] * f;
        result[1] = v[1] * f;
        result[2] = v[2] * f;
    }

    // Adapted Möller-Trumbore test for line segments
    public static boolean lineSegmentTriangleIntersection(
        double p0[], double p1[],
        double v0[], double v1[], double v2[]) 
    {
        double edge1[] = new double[3];
        double edge2[] = new double[3];
        double tVec[] = new double[3];
        double pVec[] = new double[3];
        double qVec[] = new double[3];
        double dir[] = new double[3];
        double normal[] = new double[3];

        SUB(edge1, v1, v0);
        SUB(edge2, v2, v0);
        SUB(dir, p1, p0);
        SCALE(dir, dir, 1.0 / Math.sqrt(DOT(dir, dir)));
        CROSS(pVec, dir, edge2);
        double det = DOT(edge1, pVec);
        if (det > -EPSILON && det < EPSILON)
        {
            return false;
        }
        double invDet = 1.0 / det;
        SUB(tVec, p0, v0);
        double u = DOT(tVec, pVec) * invDet;
        if (u < 0.0 || u > 1.0)
        {
            return false;
        }
        CROSS(qVec, tVec, edge1);
        double v = DOT(dir, qVec) * invDet;
        if (v < 0.0 || (u + v) > 1.0)
        {
            return false;
        }
        CROSS(normal, edge1, edge2);
        SCALE(normal, normal, 1.0 / Math.sqrt(DOT(normal, normal)));
        double d0 = DOT(normal, p0);
        double d1 = DOT(normal, p1);
        return (d0 > 0) != (d1 > 0);
    }


    //=========================================================================
    // The part below is an overly simple implementation of  
    // https://en.wikipedia.org/wiki/
    //     M%C3%B6ller%E2%80%93Trumbore_intersection_algorithm
    // only as a reference

    public static boolean rayTriangleIntersection(
        double origin[], double dir[],
        double v0[], double v1[], double v2[],
        double tuv[]) 
    {
        double edge1[] = new double[3];
        double edge2[] = new double[3];
        double tVec[] = new double[3];
        double pVec[] = new double[3];
        double qVec[] = new double[3];

        SUB(edge1, v1, v0);
        SUB(edge2, v2, v0);
        CROSS(pVec, dir, edge2);
        double det = DOT(edge1, pVec);
        if (det > -EPSILON && det < EPSILON)
        {
            return false;
        }
        double invDet = 1.0 / det;
        SUB(tVec, origin, v0);
        double u = DOT(tVec, pVec) * invDet;
        if (u < 0.0 || u > 1.0)
        {
            return false;
        }
        CROSS(qVec, tVec, edge1);
        double v = DOT(dir, qVec) * invDet;
        if (v < 0.0 || (u + v) > 1.0)
        {
            return false;
        }
        double t = DOT(edge2, qVec) * invDet;
        if (t > EPSILON)
        {
            tuv[0] = t;
            tuv[1] = u;
            tuv[2] = v;
            return true;
        }
        return false;
    }

}
class Algebra
{
    static double quadSolve(double a, double b, double c)
    {
        double result = /* do math...  we're ignoring the negative result here*/;

        return result;
    }

    public static void main(String[] args)
    {
        double x = quadSolve(1.0, -6.0, 9.0);
        //now we can do whatever we want with result: 
        //print it, negate it, pass it to another method-- whatever.
        System.out.println("The solution to the quadratic equation is: " + x);
        System.out.println("And it's square is: " + (x * x));
    }
}
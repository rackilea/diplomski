public static double RiemannIntegration
    (Func<double, double> fx,
     double x0,
     double x1,
     double step)
{
    var previous = x0;
    var res = 0d;
    var semiStep = step / 2;

    for (var x = x0 + step; x < x1; x += step)
    {
        res += semiStep * (fx(x) + fx(previous));
        previous = x;
    }

    res += (x1 - previous) / 2 * (fx(x1) + fx(previous));
    return res;
}
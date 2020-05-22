public static double RiemannIntegration(
    (double X, double Y)[] xy)
{
    var res = 0d;

    for (var i = 1; i < xy.Length; i++)
    {
        res += (xy[i].X - xy[i - 1].X) * (xy[i].Y + xy[i - 1].Y) / 2;
    }

    return res;
}
public static IEnumerable<(double X, double Y)> RiemannIntegration(
    (double X, double Y)[] xy, double initialValue)
{
    var res = initialValue;
    yield return (xy[0].X, initialValue);

    for (var i = 1; i < xy.Length; i++)
    {
        res += (xy[i].X - xy[i - 1].X) * (xy[i].Y + xy[i - 1].Y) / 2;
        yield return (xy[i].X, res);
    }
}
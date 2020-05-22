boolean atLeastThreeMatches()
{
    int count = 0;
    count += (a == a1)?1:0;
    count += (b == b1)?1:0;
    count += (c == c1)?1:0;
    count += (d == d1)?1:0;
    count += (e == e1)?1:0;
    return (count >= 3);
}
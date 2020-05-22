//in this case, "this" points to object "A".
public Coord copy()
{
    //creates an object "B"
    Coord clone = new Coord(r, c);

    //***overwrites object "A" with object "B"!***
    this = clone;

    //returns object "B"
    return clone;
}
//object "A" gets garbage collected?
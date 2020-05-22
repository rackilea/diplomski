public boolean equals(Object o)
{
    if(o instanceof Coord)
    {
        Coord newValue = (Coord)o;
        return this.r == newValue.r && this.c == newValue.c;
    }
    else 
        return false;
}
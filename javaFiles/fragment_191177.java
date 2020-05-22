@Override
public boolean equals(Object object)
{
    Sport sport = (Sport)object;
    return this.name.equals( sport.getName() );
}

@Override
public int hashCode()
{
    return name.hashCode();
}
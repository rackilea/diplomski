public int compareTo( Object o )
{
    if ( this.order < ((Category) o).order )
    {
      return -1;
    }
    else if ( this.order > ((Category) o).order ) 
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
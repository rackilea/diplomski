private Integer row = null;
private Integer col = null;

// Has the location been initialized
public boolean isLocationSet()
{
    if(row == null || col == null)
    {
        return false;
    }

    return true;
}
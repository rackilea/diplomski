private int row = 0;
private int col = 0;

// Has the location been initialized
public boolean isLocationSet()
{
    if(row <= 0 || col <= 0)
    {
        return false;
    }

    return true;
}
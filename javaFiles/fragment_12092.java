if(pointY1 == pointY2)
{
    if(pointX1 + 1 == pointX2
        || pointX1 - 1 == pointX2)
        return true;
}

if(pointX1 == pointX2)
{
    if(pointY1 + 1 == pointY2
        || pointY1 - 1 == pointY2)
        return true;
}
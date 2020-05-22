try
{
    maxX = getWidth();
    maxY = getHeight();
    count = 0;
    hour = new int[30];
    min = new int[30];
    sec = new int[30];
    msec = new int[30];
    start = false;
    stop = true;
    for(int j = 0  ; j <= 30 ; j++)
    {
        hour[j] = 0;
        min[j] = 0;
        sec[j] = 0;
        msec[j] = 0;
    }
}catch(Exception e)
{} // <- catches the exception and does nothing
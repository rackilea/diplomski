public boolean stopAtRange(double number, double current, double accuracy)
{
    if( Math.abs(current - number) <= accuracy)
    {
        return true;
    }
    return false;
}
class SubY_generalist implements Y
{
    public Y f()
    {
        Y y = new SubY_generalist();
        ...
        return y;
    }
}
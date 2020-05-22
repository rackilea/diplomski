new Outer()
{
    public Outer getOuter()
    {
        return this;
    }

    public void outerMethod()
    {
        new Inner()
        {
            public void innerMethod()
            {
                getOuter().hashCode();
            }
        };
    }
};
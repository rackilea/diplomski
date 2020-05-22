public Class C extends B
{
    public C(Object a, Object b, Object c)
    {
        super(a, b, c);  //This will call B(a, b, c)
        //do any initialization needed
    }
}
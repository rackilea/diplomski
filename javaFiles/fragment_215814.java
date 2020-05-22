public Class B extends A
{
    public B(Object a, Object b, Object c)
    {
        super(a, b);  //This will call A(a, b)
        //do any initialization needed
    }
}
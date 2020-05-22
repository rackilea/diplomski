private int i;
public int SomeProperty
{
    [MethodImpl(MethodImplOptions.Synchronized)]
    get { return i; }
    [MethodImpl(MethodImplOptions.Synchronized)]
    set { i = value; }
}
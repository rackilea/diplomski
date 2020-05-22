public class B<TWorkItemType, TContainderType extends A<TWorkItemType>>
{
    //...

    public void DoWork()
    {
        for (TWorkItemType item : temp.getList())
        {
            System.out.println(item);
        }
    }
}
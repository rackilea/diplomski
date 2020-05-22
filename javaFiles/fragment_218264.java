public static void BubbleSort()
{
    for (int i = 0; i < list.size(); i++)
    {
        for (int j=i+1; j < list.size(); j++)
        {
            if(Integer.valueOf(list.get(i).toString()) > Integer.valueOf(list.get(j).toString()))
                Swap(list.get(j), list.get(i));
        }
    }
    System.out.println(list);
}


public static void Swap(Object object, Object object2)
{
    Object spotC = object; 
    list.set(list.indexOf(object), object2); 
    list.set(list.indexOf(object2), spotC);
}
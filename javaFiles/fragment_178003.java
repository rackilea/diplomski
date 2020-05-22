public void sort(Comparable[] lst)
{
    for(int i=0; i<lst.length; i++)
    {
        for(int j=i; j<lst.length; j++)
        {
            if(lst[i].compareTo(lst[j]) < 0)
            {
                //swap elements, sorts in ascending order
                Comparable tmp = lst[i];
                lst[i] = lst[j];
                lst[j] = tmp;
            }
        }
    }
}
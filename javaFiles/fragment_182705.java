public static <E> List<List<List<E>>> create(int dim1, int dim2, int dim3)
{
    List<List<List<E>>> list1 = new ArrayList<List<List<E>>>(dim1);
    for (int i = 0; i < dim1; i++)
    {
        List<List<E>> list2 = new ArrayList<List<E>>(dim2);
        for (int j = 0; j < dim2; j++)
        {
            List<E> list3 = new ArrayList<E>(dim3);
            for (int k = 0; k < dim3; k++)
            {
                list3.add(null);
            }
            list2.add(list3);
        }
        list1.add(list2);
    }
    return list1;
}
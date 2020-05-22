public static <T extends SuperClass> ArrayList<T extends SuperClass> getDerivedClassList(Cursor data)
{
    ArrayList<T> list = new ArrayList<T>();

    for(int i=0;i<data.getCount();i++)
    {
        data.moveToPosition(i);
        T wev = new T(data);
        list.add(wev);
    }

    data.close();
    return list;
}
class Main$1<T>
    extends ArrayList<T>
{
    private final List<T> list;

    Main$1(final List<T> a)
    {
        list = a;
    }

    @Override
    public boolean add(T element)
    {
        super.add(element);
        return list.add(element);
    }
}
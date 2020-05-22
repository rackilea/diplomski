class ALittleMoreSafe
{
    private final List<X> list;

    public ALittleMoreSafe(final List<X> list)
    {
        list = new ArrayList<X>(list);
    }

    public List<X> unsafeGetList()
    {
        return list;
    }
}
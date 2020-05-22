class AscendingComp implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2)
    {
        if (o1.equals(o2))   return 0;
        if (o1.equals(1000)) return 1;
        if (o2.equals(1000)) return -1;
        return o1.compareTo(o2);
    }
}
class DescendingComp implements Comparator<Integer>
{
    @Override
    public int compare(Integer o1, Integer o2)
    {
        if (o1.equals(o2))   return 0;
        if (o1.equals(1000)) return 1;
        if (o2.equals(1000)) return -1;
        return o2.compareTo(o1);
    }
}
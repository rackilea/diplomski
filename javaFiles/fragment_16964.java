class CompareByNumberOfA implements Comparator<Item>
{
    public int compare(Item arg0, Item arg1) 
    {
        return arg1.getCount('A') - arg0.getCount('A');
    }
}
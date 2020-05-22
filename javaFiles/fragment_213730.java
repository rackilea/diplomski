public class WeightComparator implements
    Comparator<AbstractMap.SimpleEntry<Integer, Integer>>
{
    @Override
    public int compare(AbstractMap.SimpleEntry<Integer, Integer> one,
                       AbstractMap.SimpleEntry<Integer, Integer> two)
    {
        return Integer.compare(one.getValue(), two.getValue());
    }
}
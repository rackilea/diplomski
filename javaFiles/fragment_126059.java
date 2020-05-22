public class FishNameComparator implements Comparator<Fish>
{
    public int compare(Fish left, Fish right) {
        return left.name.compareTo(right.name);
    }
}
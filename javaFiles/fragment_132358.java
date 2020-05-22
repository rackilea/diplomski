import java.util.Arrays;
import java.util.Comparator;

public class NearestObject
{
    public NearestObject(int position, int distance)
    {
         this.Position = position;
         this.Distance = distance;
    }
    public int Position = 0;
    public int Distance = 0;

    public static NearestObject[] SortDistance(NearestObject[] items)
    {
        Arrays.sort(items, new DistanceSort());
        return items;
    }

}

class DistanceSort implements Comparator<NearestObject>
{
    public int compare(NearestObject o1, NearestObject o2)
    {
        return o1.Distance - o2.Distance;
    }
}
import java.util.ArrayList;
import java.util.List;

public class EntryNumberExtractor
{
    public List<Integer> extract(List<Entry> entries)
    {
        List<Integer> integers = new ArrayList<>();
        for (Entry e : entries) 
        {
            integers.add(e.getNumber());
        }
        return integers;
    }
}
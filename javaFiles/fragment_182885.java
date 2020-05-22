import java.util.Comparator;

import com.sleepycat.bind.tuple.IntegerBinding;
import com.sleepycat.je.DatabaseEntry;

public class IntegerSorter implements Comparator<byte[]>
    {
    @Override
    public int compare(byte[] o1, byte[] o2)
        {
        return
              IntegerBinding.entryToInt(new DatabaseEntry(o1)) - 
              IntegerBinding.entryToInt(new DatabaseEntry(o2));
        }
    }

(...)
 dbConfig.setBtreeComparator(IntegerSorter.class);
(...)
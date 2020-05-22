public interface AggregationField <T>
{
    // ...
}

public interface Aggregatable <T>
{
    public void addFieldValue (T t, AggregationField <T> field);
}

public class Charges implements Aggregatable <Charges>
{
    @Override
    public void addFieldValue (
        Charges Charges, AggregationField <Charges> field)
    {
        // ...
    }
}

public class CommonAggregator <T extends Aggregatable <T>> {
    private T sum (
        AggregationField <T> field,
        List <? extends T> listOfAggregatables)
    {
        T aggregatable = listOfAggregatables.get(0);

        for (T response: listOfAggregatables.subList (1, listOfAggregatables.size())){
            aggregatable.addFieldValue(response, field);
        }

        return aggregatable;
    }
}
public class FilterByIntegerSetQuery extends Query
{
    protected String numericDocValueFieldName;
    protected Set<Integer> allowedValues;


    public FilterByIntegerSetQuery(String numericDocValueFieldName, Set<Integer> allowedValues)
    {
        this.numericDocValueFieldName = numericDocValueFieldName;
        this.allowedValues = allowedValues;
    }

    @Override
    public Weight createWeight(IndexSearcher searcher, boolean needsScores)
    {
        return new RandomAccessWeight(this)
        {
            @Override
            protected Bits getMatchingDocs(LeafReaderContext context) throws IOException
            {
                final int len = context.reader().maxDoc();
                final NumericDocValues values = context.reader().getNumericDocValues(numericDocValueFieldName);
                return new Bits()
                {
                    @Override
                    public boolean get(int index)
                    {
                        return allowedValues.contains((int) values.get(index));
                    }

                    @Override
                    public int length()
                    {
                        return len;
                    }
                };
            }
        };
    }


    @Override
    public String toString(String field)
    {
        return "(filter "+numericDocValueFieldName+" by set)";
    }
}
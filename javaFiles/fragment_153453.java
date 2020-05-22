public static void looksLike(boolean matchSize, Result<?> results, Row ... theseRows)
{
    if (matchSize)
    {
        assertEquals(results.size(), theseRows.length);
    }

    List<Row> resultsRows = new ArrayList<Row>();
    for (Record r : results)
    {
        resultsRows.add(r.valuesRow());
    }

    for (Row r : theseRows)
    {
        assertTrue(r.toString() + " missing from " + results, resultsRows.contains(r));
    }
}
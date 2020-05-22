private List<String> convertCSVRecord(
    final CSVRecord record)
{
    final List<String> returnValue = new LinkedList<String>();

    for (final String currentValue : record)
    {
        returnValue.add(currentValue);
    }

    return returnValue;
}
@DataProvider
public Iterator<Object[]> testData()
    throws IOException
{
    final List<Object[]> list = new ArrayList<>();

    for (final String line: Files.readAllLines(Paths.get("whatever"),
        StandardCharsets.UTF_8)
        list.add(new Object[]{ line, process(line) };

    return list.iterator();
}

private static Whatever process(final String line)
{
    // whatever
}
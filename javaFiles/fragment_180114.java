public final class Foo
{
    private static final List<String> productList = Arrays.asList(
        "rose", "flower", "banana", "parrot", "rose", "bird", "flower", "rose",
        "banana", "bird"
    );

    private static List<String> indicesFor(final List<String> list)
    {
        final Map<String, Integer> indices = new HashMap<String, Integer>();

        final int size = list.size();

        for (int i = 0; i < size; i++)
            indices.put(list.get(i), i);

        final List<String> ret = new ArrayList<String>(indices.size());
        for (final Map.Entry<String, Integer> entry: indices.entrySet())
            ret.add(entry.toString());
        return ret;
    }

    public static void main(final String... args)
    {
        System.out.println(indicesFor(productList));
        System.exit(0);
    }
}
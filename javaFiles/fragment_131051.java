public class StreamSplitter<T>
    implements Iterator<Stream<T>>
{
    private Iterator<T>  incoming;
    private Predicate<T> startOfNewEntry;
    private T            nextLine;

    public static <T> Stream<Stream<T>> streamOf(Stream<T> incoming, Predicate<T> startOfNewEntry)
    {
        Iterable<Stream<T>> iterable = () -> new StreamSplitter<>(incoming, startOfNewEntry);
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    private StreamSplitter(Stream<T> stream, Predicate<T> startOfNewEntry)
    {
        this.incoming = stream.iterator();
        this.startOfNewEntry = startOfNewEntry;
        if (incoming.hasNext())
            nextLine = incoming.next();
    }

    @Override
    public boolean hasNext()
    {
        return nextLine != null;
    }

    @Override
    public Stream<T> next()
    {
        List<T> nextEntrysLines = new ArrayList<>();
        do
        {
            nextEntrysLines.add(nextLine);
        } while (incoming.hasNext()
                 && !startOfNewEntry.test((nextLine = incoming.next())));

        if (!startOfNewEntry.test(nextLine)) // incoming does not have next
            nextLine = null;

        return nextEntrysLines.stream();
    }
}
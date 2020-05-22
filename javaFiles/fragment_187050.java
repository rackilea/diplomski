static final ConcurrentSkipListSet<Widget>[] queued = newArray(N);
// note: declare the most specific type for private objects


@SafeVarargs
static <E> E[] newArray(int length, E... array)
{
    return Arrays.copyOf(array, length);
}
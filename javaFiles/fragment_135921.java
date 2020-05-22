private final Executor[] streamThreads
        = new Executor[Runtime.getRuntime().availableProcessors()];
{
    for (int i = 0; i < streamThreads.length; ++i) {
        streamThreads[i] = Executors.newSingleThreadExecutor();
    }
}
private final ConcurrentHashMap<SubstreamId, Integer>
        threadById = new ConcurrentHashMap<>();
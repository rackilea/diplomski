public abstract class LineLoader<T, C extends Collection<T>> implements LineProcessor<C> {        
    private final C result;

    protected LineLoader(C collection) {
        result = collection;  
    }

    protected boolean add(final T line) {
        return result.add(line);
    }

    @Override
    public boolean processLine(final String line) throws IOException {
        final T data = parser.parseLine(line);

        if (data == null) {
            return false;
        }

        return add(data);            
    }

    @Override
    public C getResult() {
        return result;
    }
}
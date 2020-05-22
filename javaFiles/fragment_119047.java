class FileReader implements Iterable<String> {

    @Override
    public Iterator<String> iterator() {
        return new FileReaderIterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) { }

    @Override
    public Spliterator<String> spliterator() { return null; }

    class FileReaderIterator implements Iterator<String> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }

        @Override
        public void remove() { }

        @Override
        public void forEachRemaining(Consumer<? super String> action) { }
    }
}
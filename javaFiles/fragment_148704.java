public Iterator<Foo> iterator() {
    return new Iterator<Foo>() {
        public boolean hasNext() { 
            return false;
        }
        public Foo next() {
            throw new NoSuchElementException();
        }
    };
}
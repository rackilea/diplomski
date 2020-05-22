class SongList extends AbstractList<Song> implements RandomAccess {
    final List<Song> backend = new ArrayList<>();
    int currentSong = -1;

    SongList() {}
    SongList(Collection<? extends Song> c) {
        backend.addAll(c);
    }
    // mandatory query methods

    @Override public int size() {
        return backend.size();
    }
    @Override public Song get(int index) {
        return backend.get(index);
    }

    // the "iterator"
    public Song nextSong() {
        if(++currentSong < size()) {
            return get(currentSong);
        }
        currentSong = -1;
        return null;
    }

    // modifying methods, which will adapt the pointer

    @Override public void add(int index, Song element) {
        backend.add(index, element);
        if(index <= currentSong) currentSong++;
    }
    @Override public Song remove(int index) {
        final Song removed = backend.remove(index);
        if(index <= currentSong) currentSong--;
        return removed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Song> c) {
        int old = size();
        backend.addAll(index, c);
        if(index <= currentSong) currentSong += size() - old;
        return true;
    }

    @Override protected void removeRange(int fromIndex, int toIndex) {
        backend.subList(fromIndex, toIndex).clear();
        if(fromIndex <= currentSong)
            currentSong = Math.max(fromIndex - 1, currentSong - toIndex + fromIndex);
    }

    // this will not change the pointer

    @Override public Song set(int index, Song element) {
        return backend.set(index, element);
    }

    // query methods overridden for performance

    @Override public boolean contains(Object o) {
        return backend.contains(o);
    }
    @Override public int indexOf(Object o) {
        return backend.indexOf(o);
    }
    @Override public Spliterator<Song> spliterator() {
        return backend.spliterator();
    }
    @Override public void forEach(Consumer<? super Song> action) {
        backend.forEach(action);
    }
    @Override public Object[] toArray() {
        return backend.toArray();
    }
    @Override public <T> T[] toArray(T[] a) {
        return backend.toArray(a);
    }
    @Override public String toString() {
        return backend.toString();
    }
}
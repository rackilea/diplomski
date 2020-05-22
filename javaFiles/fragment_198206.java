public class MyArrayList<E> implements Iterable<E> {
    ...

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Object[] currentData = items;
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < currentData.length;
            }

            @Override
            public E next() {
                return (E) currentData[pos++];
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(pos++);
            }
        };
    }
}
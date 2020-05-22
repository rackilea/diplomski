public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.iterate(0, integer -> integer);

        Stream<Integer> stream2 = Stream.iterate(1, integer -> integer)
                .limit(4);

        Stream<Integer> zippedStreams = StreamSupport.stream(new Ziperator<>(stream1, stream2).spliterator(), false);

        zippedStreams.limit(15).forEach(System.out::println);

    }


    public static class Ziperator<T> implements Iterator<T>, Iterable<T>{
        Iterator<T> iterator1;
        Iterator<T> iterator2;
        boolean even = true;


        @Override
        public Iterator<T> iterator() {
            return this;
        }

        public Ziperator(Stream<T> first, Stream<T> second) {
            iterator1 = first.iterator();
            iterator2 = second.iterator();
        }

        public boolean hasNext(){
            return iterator1.hasNext() || iterator2.hasNext();
        }

        @Override
        public T next() {
            if(!iterator2.hasNext()){
                even = true;
            }
            if(!iterator1.hasNext()){
                even = false;
            }
            if (even) {
                even = false;
                return iterator1.next();
            } else {
                even = true;
                return iterator2.next();
            }
        }

        @Override
        public void remove() {

        }
    }
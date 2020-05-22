public static <T> Stream<List<T>> combinations(T[] arr) {
    final long N = (long) Math.pow(2, arr.length);
    return StreamSupport.stream(new AbstractSpliterator<List<T>>(N, Spliterator.SIZED) {
        long i = 1;
        @Override
        public boolean tryAdvance(Consumer<? super List<T>> action) {
            if(i < N) {
                List<T> out = new ArrayList<T>(Long.bitCount(i));
                for (int bit = 0; bit < arr.length; bit++) {
                    if((i & (1<<bit)) != 0) {
                        out.add(arr[bit]);
                    }
                }
                action.accept(out);
                ++i;
                return true;
            }
            else {
                return false;
            }
        }
    }, false);
}
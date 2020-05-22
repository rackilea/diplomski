private static Stream<String> getStream(BufferedReader br) {
    return StreamSupport.stream(
        new Spliterators.AbstractSpliterator<String>(
                                            100, Spliterator.ORDERED|Spliterator.NONNULL) {
            String prev;
            public boolean tryAdvance(Consumer<? super String> action) {
                try {
                    String next = br.readLine();
                    if(next==null) return false;
                    final int ix = next.indexOf(',');
                    if(ix==0) {
                        if(prev==null)
                            throw new IllegalStateException("first line without value");
                        next = prev+next;
                    }
                    else prev=ix<0? next: next.substring(0, ix);
                    action.accept(next);
                    return true;
                } catch (IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            }
        }, false);
}
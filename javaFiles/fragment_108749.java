static StreamEx<TemporaryB> combine(StreamEx<A> input, TemporaryB tb) {
    return input.headTail((head, tail) ->
        tb == null ? combine(tail, new TemporaryB(head)) :
            tb.fits(head) ? combine(tail, tb.add(head)) :
                combine(tail, new TemporaryB(head)).prepend(tb), 
        () -> StreamEx.ofNullable(tb));
}
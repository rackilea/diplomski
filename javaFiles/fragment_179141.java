private static final int ITERATION_THRESHOLD = 16; // tune yourself

public static <T> Consumer<T> combineAllTasks(Stream<Consumer<T>> consumers) {
    List<Consumer<T>> consumerList = consumers.collect(Collectors.toList());
    if(consumerList.isEmpty()) return t -> {};
    if(consumerList.size() == 1) return consumerList.get(0);
    if(consumerList.size() < ITERATION_THRESHOLD)
        return balancedReduce(consumerList, Consumer::andThen, 0, consumerList.size());
    return t -> consumerList.forEach(c -> c.accept(t));
}
private static <T> T balancedReduce(List<T> l, BinaryOperator<T> f, int start, int end) {
    if(end-start>2) {
        int mid=(start+end)>>>1;
        return f.apply(balancedReduce(l, f, start, mid), balancedReduce(l, f, mid, end));
    }
    T t = l.get(start++);
    if(start<end) t = f.apply(t, l.get(start));
    assert start==end || start+1==end;
    return t;
}
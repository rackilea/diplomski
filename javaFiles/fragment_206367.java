static void addToQueue2(int value, Trace currentTrace, LinkedList<Trace> queue) {
    Trace nt = new Trace(value);
    nt.path = (LinkedList<Integer>)currentTrace.path.clone();
    nt.path.addFirst(value);
    queue.addLast(nt);
}

static LinkedList<Integer> findPath2(int from, int to) throws Exception {
    if (from < to) throw new Exception("from < to");
    LinkedList<Trace> q = new LinkedList<Trace>();
    Trace t = new Trace(to);
    t.path.addFirst(to);
    q.addLast(t);

    while (!q.isEmpty()) {
        Trace e = q.getFirst();
        q.removeFirst();
        int cv = e.currentValue;
        if (cv == from) return e.path;
        if (cv > from) continue;

        addToQueue2(cv+1, e, q);
        addToQueue2(cv*3, e, q);
        addToQueue2(cv*5, e, q);
    }
    throw new Exception("no path");
}
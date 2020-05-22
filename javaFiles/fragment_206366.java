static class Trace {
    public int currentValue;
    public LinkedList<Integer> path;

    public Trace(int val) { currentValue = val; path = new LinkedList<Integer>(); }
}

static void addToQueue(int value, Trace currentTrace, LinkedList<Trace> queue) {
    Trace nt = new Trace(value);
    nt.path = (LinkedList<Integer>)currentTrace.path.clone();
    nt.path.addLast(value);
    queue.addLast(nt);
}

static LinkedList<Integer> findPath(int from, int to) throws Exception {
    // Safety check
    if (from < to) throw new Exception("from < to");
    LinkedList<Trace> q = new LinkedList<Trace>();

    // Initialize queue with FROM value
    Trace t = new Trace(from);
    t.path.addLast(from);
    q.addLast(t);

    // Repeat till we have an answer
    while (!q.isEmpty()) {
        Trace e = q.getFirst();
        q.removeFirst();
        int cv = e.currentValue;

        // Check if we have a solution 
        if (cv == to) return e.path;


        // Handle steps of -1, /3 and /5
        if (cv-1 >= to)
            addToQueue(cv-1, e, q);

        if (cv%3 == 0 && cv/3 >= to)
            addToQueue(cv/3, e, q);

        if (cv%5 == 0 && cv/5 >= to)
            addToQueue(cv/5, e, q);
    }

    // This will never execute because of existence of linear path
    // of length(levels) FROM - TO
    throw new Exception("no path");
}
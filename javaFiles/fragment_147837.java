public static <T> Queue<T> mergeQs(Queue<T> ... qs) {
    Queue<T> ret = new ConcurrentLinkedQueue<T>();
    boolean more;
    do {
        more = false;
        for (Queue<T> q : qs) 
            if (!q.isEmpty()) {
                ret.add(q.remove());
                more = true;
            }
    } while(more);
    return ret;
}
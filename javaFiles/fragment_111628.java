public void add(Task t) {
    synchronized (mutex) {
        queue.add(t);

        list.clear();

        ArrayList<Task> al = new ArrayList<Task>();

        while (queue.size() > 0)
            al.add(queue.remove());

        for (Task ta : al) {
            list.addElement(ta);
            queue.add(ta);
        }
    }
}
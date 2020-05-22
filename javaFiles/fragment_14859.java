public void enqueue(T event) {
    List<T> removable = new ArrayList<>();
    synchronized (events) {
        final int size = events.size();
        if (size > 2000) {
            for (int i = 0; i < size; i++) {
                final T t = events.get(i);
                if (canRemove(t)) {
                    removable.add(t);
                    break;
                }
            }
        }
        if (removable.size() > 0) {
            events.removeAll(removable);
        }
       events.add(event);
    }
}
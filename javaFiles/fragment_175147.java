public T removeMin() {
    Iterator<T> it = iterator();
    T min = (it.hasNext()) ? it.next() : null;
    while (it.hasNext()) {
        T next = it.next();
        if (min.compareTo(next) > 0) {
            min = next;
        }
    }
    it = iterator(); // <-- start again
    while (it.hasNext()) {
        T next = it.next();
        if (min.compareTo(next) == 0) {
            it.remove();
            break;
        }
    }
    System.out.println(min);
    return min;
}
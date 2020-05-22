private <E extends Number> double GetAverage(ArrayList<E> al) {
    double total = 0;
    Iterator<E> itr = al.iterator();
    while (itr.hasNext()) {
        E next = itr.next();
        total += next.doubleValue();
    }

    return total;
}
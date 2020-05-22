public MyList<E> mergeSort(Collection<? extends E> list1) {
    //Copy this list in another one and clear it
    List<E> list2 = new ArrayList<E>(this);
    this.clear();
    //Merge values until one list is exhausted
    Iterator<? extends E> it1 = list1.iterator();
    Iterator<? extends E> it2 = list2.iterator();
    if (it1.hasNext() && it2.hasNext()) {
        E value1 = it1.next(), value2 = it2.next();
        do {
            if (value1.compareTo(value2) <= 0) {
                this.add(value1);
                if (it1.hasNext()) {
                    value1 = it1.next();
                } else {
                    this.add(value2);
                    break;
                }
            } else {
                this.add(value2);
                if (it2.hasNext()) {
                    value2 = it2.next();
                } else {
                    this.add(value1);
                    break;
                }
            }
        } while (true);
    }
    //copy remaining values
    while (it1.hasNext()) {
        this.add(it1.next());
    }
    while (it2.hasNext()) {
        this.add(it2.next());
    }
    return this;
}
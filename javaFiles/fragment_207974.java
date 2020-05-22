public int size() {
    if (fromStart && toEnd)
        return m.size();
    if (size == -1 || sizeModCount != m.modCount) {
        sizeModCount = m.modCount;
        size = 0;
        Iterator i = iterator();
        while (i.hasNext()) {
            size++;
            i.next();
        }
    }
    return size;
}
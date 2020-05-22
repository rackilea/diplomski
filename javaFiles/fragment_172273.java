T previous = null;
for (Iterator<T> i = map.keySet().iterator(); i.hasNext();) {
    T element = i.next();

    // Do something with "element" and "previous" (if not null)

    previous = element;
}
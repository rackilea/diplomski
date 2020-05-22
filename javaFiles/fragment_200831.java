public boolean contains(Object o) {
    return indexOf(o) != -1;
}
public int indexOf(Object o) {
    int index = 0;
    if (o==null) {
        /* snipped */ 
    } else {
        for (Entry e = header.next; e != header; e = e.next) {
            if (o.equals(e.element))
                return index;
            index++;
        }
    }
    return -1;
}
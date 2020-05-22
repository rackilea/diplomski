if (o == null) {
    for (Entry e = header.next; e != header; e = e.next) {
        if (e.element == null)
            return index;
        index++;
    }
} else {
    for (Entry e = header.next; e != header; e = e.next) {
        if (o.equals(e.element))
            return index;
        index++;
    }
}
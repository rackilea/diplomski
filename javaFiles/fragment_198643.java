LinkedList<Object> list = new LinkedList<>();
for(ListIterator<Object> it = list.listIterator();;) {
    for(;;) {
        it.add(new Object());
        if(!it.hasNext()) break;
        it.next();
    }
    while(it.hasPrevious()) {
        it.previous();
        it.add(new Object());
        it.previous();
    }
}
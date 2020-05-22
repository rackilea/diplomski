void sell(Collection<? extends T> items) {

    Iterator<? extends T> ir = items.iterator();

    while (ir.hasNext()){
        stock.add(ir.next());
    }
}
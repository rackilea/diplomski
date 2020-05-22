public void enqueue(Object newItem){
    if (!isFull()){
         ...
    } else {
        Object[] newItems = new Object[items.length * 2];
        copyFromTo(items, newItems);
        items = newItems;
        enqueue(newItem);
    }
}
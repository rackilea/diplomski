Queue<IntSupplier> queue = // some new queue
queue.add(() -> add(10, 20));
queue.add(() -> add(20, 30));

// The getAsInt-method calls the supplier and gets its value.
int result1 = queue.remove().getAsInt();
int result2 = queue.remove().getAsInt();
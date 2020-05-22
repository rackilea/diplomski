final ArrayList<Integer> list;
// ...
synchronized (list) {
  if (list.isEmpty()) {
    System.out.println("Consumer : List is empty");
    list.wait();
  } else {
    int removedItem = list.remove(list.size() - 1);
    Thread.sleep(200);
    list.notify();
    System.out.println("Value consumed by the consumer : " + removedItem);
  }
}
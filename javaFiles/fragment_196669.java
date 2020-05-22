final ArrayList<Integer> list;
// ...
synchronized (list) {
  if (list.size() == size) {
    System.out.println("Producer : List is full");
    list.wait();
  } else {
    list.add(++value);
    Thread.sleep(200);
    list.notify();
    System.out.println("Value produce by the producer : " + value);
  }
}
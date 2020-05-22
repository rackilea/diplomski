Iterator<Pair<Long,Order>> iter = getOrderSet().iterator();
while (iter.hasNext()) {
      Pair<Long,Order> pair = iter.next();
      System.out.println("ID " + pair.getFirst());
      System.out.println("Order " + pair.getSecond());
}
Iterator<String> iterator = allOrders.iterator();
String latest = "";
while (iterator.hasNext()) {
  String current = iterator.next();
  if (current.equals(latest)) {
    iterator.remove();
  }
  latest = current;
}
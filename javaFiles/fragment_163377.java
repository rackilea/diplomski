class Order {
   long[] available;
   long[] approved;
   ...
}

Order order = gson.fromJson("{ your json goes here }", Order.class);

List<Long> result = new ArrayList<Long>();
result.add(order.getAvailable());
result.add(order.getApproved());
...
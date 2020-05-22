HashMap map = new HashMap();
map.put("one", new OrderItem());
OrderItem one = map.get("one");
OrderItem two = map.get("one");
one.setStatus(1);
two.setStatus(2);
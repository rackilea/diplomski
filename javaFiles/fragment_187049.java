Map<String, Double> menu = new HashMap<>();
Double totalPrice = 0;
menu.put("chicken", 10); // The example of adding element to the map, add another items to menu like that
order.add("chicken");

for (int z = 0; z < Order.size(); z++)
    totalPrice += menu.get(order.get(z)); // + 5
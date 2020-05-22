double tally = 0;
for (Map.Entry<String, Integer> enrty : order.entrySet()) {
    String name = enrty.getKey();
    int quantity = enrty.getValue();
    double price = menu.get(name);
    double total = quantity * price;
    tally += total;

    System.out.println(quantity + "x " + name + " @ " + price + " = " + total);
}
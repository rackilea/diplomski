int totalPrice = 0;
for (Orderable order : orders) {
    System.out.println(order.getName() + " - " order.getPrice());
    totalPrice += order.getPrice();
}
System.out.println("Total price: ");
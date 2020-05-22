Iterator<Order> orders = theorder.iterator();
boolean found = false;
while ( !found && orders.hasNext() ) {
    if ( orders.next().getOrderID() == orderIDSearch ) {
        found = true;
    }
}
if ( found ) {
    orders.remove();
    System.out.println("Found and removed [ " + orderIDSearch + " ]");
} else {
    System.out.println("Not found [ " + orderIDSearch + " ]");
}
boolean found = false;
for ( Order o : theorder ) {
    if ( o.getOrderID() == orderIDSearch ) {
        found = true;
        break;            
    }
}
if ( found ) {
    theorder.remove(orderIDSearch);
    System.out.println("Found and removed [ " + orderIDSearch + " ]");
} else {
    System.out.println("Not found [ " + orderIDSearch + " ]");
}
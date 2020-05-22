for ( Order o : theorder ) {
    if ( o.getOrderID() == orderIDSearch ) {
        theorder.remove(orderIDSearch);
        System.out.println("Order has been successfully removed");              
        continue;
    } else {
        System.out.println("Not found ");
        break;
    }
}
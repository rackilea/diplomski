private void lblinvoiceMouseReleased(java.awt.event.MouseEvent evt) {
    String name = "Invoice";
    Invoice invoice = new Invoice();
    invoice.setName(name); 
    load(name, invoice, lblinvoice);
}

private void lblReservationMouseReleased(java.awt.event.MouseEvent evt){
    String name = "Reservation";
    Reservation reservation = new Reservation();
    reservation.setName(name);
    load(name, reservation, lblReservation);

}
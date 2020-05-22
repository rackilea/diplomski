public boolean sellTickets(int noOfTickets) {
    if(availableTickets >= noOfTickets) {
        moneyMade += noOfTickets * pricePerTicket;
        availableTickets -= noOfTickets;
        return true;
    }
    return false;
}
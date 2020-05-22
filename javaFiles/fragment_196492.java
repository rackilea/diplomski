Ticket ticket;
for (i=0; i<tickets.size(); i++){
    ticket = tickets.get(i);
    if(ticket.getPurchased()== false){
        theDateArray.add(ticket.getDate());
    }

}
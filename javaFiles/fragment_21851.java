@Override
public void addTicketComment(String ticketID, String ticketComment) {          
    Ticket ticket = mongoTemplate.findById(ticketID, Ticket.class);
    ticket.getTicketComments().add(ticketComment);
    mongoTemplate.save(ticket);
}
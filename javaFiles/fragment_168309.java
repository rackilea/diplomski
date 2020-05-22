public void deleteUserTicketEntity(UserTicketEntity ticket) {
    // delete passed in object
    this.sessionFactory.getCurrentSession().delete(ticket);
}

public void deleteUserTicketEntityById(long ticketNumber) {
    // instantiate new object w/ ID, then delete
    final UserTicketEntity deleteTicket = new UserTicketEntity();
    deleteTicket.setId(ticketNumber);
    this.sessionFactory.getCurrentSession().delete(deleteTicket);
}
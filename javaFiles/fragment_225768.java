while (true) {
  session.getTransaction().begin();

  try {  
    Query query1 = session.createSQLQuery("select TOP 1 * from CustomerTicket where customerId is null");
    Object[] customerTicket = (Object[])query1.uniqueResult();

    Integer id = (Integer)customerTicket[0];
    ticketId = (String)customerTicket[1];
    logger.debug("Got ticket id -->"+ticketId);

    Query query2 = session.createSQLQuery("update CustomerTicket " +
                                            "set customerId = :customerId " +
                                            "where ticketId = :ticketId AND customerId is NULL");  
                                            // Notice the AND clause!!!
    query2.setParameter("customerId", customerId);
    query2.setParameter("ticketId", ticketId);
    logger.debug("QUery 2 executeUpdate : customerId : "+customerId+", ticketId :"+ticketId);
    int updateCount = query2.executeUpdate();
    logger.debug("updateCount >"+updateCount +", customerTicketId ----------->"+customerId+", ticketId ------------>"+ticketId);

    //  Did someone beat us to it? 
    if (updateCount == 0) {
        session.getTransaction().rollback();
        continue;
    }

    // Nope - we're winning so far, but the race isn't over yet...
    session.getTransaction().commit();
  } catch (OptimisticLockException ex) {
      logger.debug("Darn, someone DID beat us to it");
      session.getTransaction().rollback();
      continue;
  } catch (Exception ex) {
      ...
  }

  break;
}
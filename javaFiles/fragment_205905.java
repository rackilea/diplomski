Offer offer = (Offer) session.createQuery(
    "select o " +
    "from Offer o " +
    "where o.id = ( select max(g.point_To) from Offer o1 join o1.giftManagement g where o1.customer.id =:customerId ) ")
.setParameter("customerId", id)
.uniqueResult();
public List<Clients> selectWithParameters(Criteria criteria) {
    log.info(criteria.toString());
    String opener = criteria.getOpener();
    String closer1 = criteria.getCloser1();
    String status = criteria.getStatus();

    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Clients> query = criteriaBuilder.createQuery(Clients.class);
    Root<Clients> c = query.from(Clients.class);
    List<Predicate> wherePredicates = new LinkedList<Predicate>();
    if (null != status) {
        wherePredicates.add(criteriaBuilder.like(c.get("status"), status));
    }
    if (null != closer1) {
        wherePredicates.add(criteriaBuilder.like(c.get("closer1"), closer1));
    }
    if (null != opener) {
        wherePredicates.add(criteriaBuilder.like(c.get("opener"), opener));
    }
    query.where(wherePredicates.toArray(new Predicate[0]));

    List<Clients> clients = em.createQuery(query).getResultList();
    log.fine(clients.toString());
    return clients;
}
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Tuple> q = cb.createQuery(Tuple.class);
Root<Stock> sRoot = q.from(Stock.class);
Root<StockGroup> sgRoot = q.from(StockGroup.class);

q.select(cb.tuple(sRoot, sgRoot)).where(
    cb.and(cb.equal(sRoot.get(Stock_.stockGroup), sgRoot),
        cb.isTrue(sRoot.get(Stock_.visible))));
List<Tuple> l = em.createQuery(q).getResultList();
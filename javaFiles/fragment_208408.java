// notice I changed all <T> to <App>
public List<App> findByPage(int pageNum, int pageSize) {
        CriteriaQuery<App> cq = getEntityManager()
                .getCriteriaBuilder().createQuery(entity);

        Root<App> root = query.from(App.class); // added this
        root.fetch("app");                      // added this, this is the join

        cq.select(cq.from(entity));

        int firstResult = pageNum * pageSize;
        return getEntityManager().createQuery(cq)
                .setFirstResult(firstResult)
                .setMaxResults(pageSize)
                .getResultList();
}
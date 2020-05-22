public List<Post> findPostBySitePaged(Set sites, Page page) {
    List<Post> result = new ArrayList<Post>();
    if (sites == null || sites.size() == 0) return result;

    try {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Long> cQuery = builder.createQuery(Long.class);
        Root<Post> root = cQuery.from(Post.class);

        CriteriaQuery<Long> select = cQuery.select(builder.count(root));
        select.where(root.get("site").in(sites));

        TypedQuery<Long> typedQuery = em.createQuery(select);
        Long t = typedQuery.getSingleResult();

        int tot = t.intValue() / page.getPageSize() + ((t.intValue() % page.getPageSize()) == 0 ? 0 : 1);
        page.setTotal(tot);

        CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
        root = criteriaQuery.from(Post.class);
        criteriaQuery.select(root).where(root.get("site").in(sites)).orderBy(builder.desc(root.get("createDate")));

        TypedQuery<Post> postQuery = em.createQuery(criteriaQuery);
        postQuery.setFirstResult((page.getCurrent() - 1) * (page.getPageSize())).setMaxResults(page.getPageSize());

        result = postQuery.getResultList();

    } catch (Exception e) {
        log.error(e.getMessage());
    }

    return result;
}
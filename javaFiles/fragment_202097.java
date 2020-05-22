public class ResourceFileRepositoryImpl implements ResourceFileRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ResourceFile> getResourceFilesOrderByFavourites() {
        CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
        CriteriaQuery<ResourceFile> q = criteriaBuilder
                .createQuery(ResourceFile.class);
        Root<FavoriteResourceFile> root = q.from(FavoriteResourceFile.class);
        Join<FavoriteResourceFile, ResourceFile> join = root.join(
                 FavoriteResourceFile_.resourceFile, JoinType.LEFT);
        q.select(join);
        q.groupBy(join.get(ResourceFile_.id));
        q.orderBy(criteriaBuilder.desc(
                      criteriaBuilder.count(
                          join.get(ResourceFile_.id))));

        TypedQuery<ResourceFile> query = this.em.createQuery(q);
        return query.getResultList();
    }
}
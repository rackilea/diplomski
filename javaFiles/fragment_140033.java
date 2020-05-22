@Repository
public interface CardCategoryLevelRepository extends JpaRepository<CardCategoryLevel, Long>, QueryDslPredicateExecutor<CardCategoryLevel>, CardCategoryLevelRepositoryCustom {

    @Override
    @EntityGraph(value = "graph.CardCategoryLevel", type = EntityGraphType.LOAD)
    List<CardCategoryLevel> findAll(Predicate predicate);

....
}

public interface CardCategoryLevelRepositoryCustom {

    Page<CardCategoryLevel> findAll(Predicate predicate, Pageable pageable);

}

public class CardCategoryLevelRepositoryImpl extends SimpleJpaRepository<CardCategoryLevel, Long> implements CardCategoryLevelRepositoryCustom {

    private final EntityManager entityManager;
    private final EntityPath<CardCategoryLevel> path;
    private final PathBuilder<CardCategoryLevel> builder;
    private final Querydsl querydsl;

    /**
     * Workaround, must be removed once fixed
     * https://jira.spring.io/browse/DATAJPA-684
     * http://stackoverflow.com/questions/36043665/querydsl-query-specified-join-fetching-but-the-owner-of-the-fetched-associati
     * 
     * @param entityManager
     */
    @Autowired
    public CardCategoryLevelRepositoryImpl(EntityManager entityManager) {
        super(CardCategoryLevel.class, entityManager);

        this.entityManager = entityManager;
        this.path = SimpleEntityPathResolver.INSTANCE.createPath(CardCategoryLevel.class);
        this.builder = new PathBuilder<>(path.getType(), path.getMetadata());
        this.querydsl = new Querydsl(entityManager, builder);
    }

    /**
     * Workaround, must be removed once fixed
     * https://jira.spring.io/browse/DATAJPA-684
     * http://stackoverflow.com/questions/36043665/querydsl-query-specified-join-fetching-but-the-owner-of-the-fetched-associati
     */
    @Override
    public Page<CardCategoryLevel> findAll(Predicate predicate, Pageable pageable) {
        JPAQuery countQuery = createQuery(predicate);
        JPAQuery query = (JPAQuery) querydsl.applyPagination(pageable, createQuery(predicate));

        query.setHint(EntityGraph.EntityGraphType.LOAD.getKey(), entityManager.getEntityGraph("graph.CardCategoryLevel"));

        Long total = countQuery.count();
        List<CardCategoryLevel> content = total > pageable.getOffset() ? query.list(path) : Collections.<CardCategoryLevel> emptyList();

        return new PageImpl<>(content, pageable, total);
    }

    private JPAQuery createQuery(Predicate predicate) {
        return querydsl.createQuery(path).where(predicate);
    }

}
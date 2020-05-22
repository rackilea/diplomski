private EntityManager em;

private Page<GeneralAnnouncementInfo> getAnnouncementsBySearchCriteria(QueryParameters qParams) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<SampleEntity> criteria = cb.createQuery(GeneralAnnouncementInfo.class);
    Root<GeneralAnnouncementInfo> root = criteria.from(GeneralAnnouncementInfo.class);

    // Programmatically build query details (conditions, joins, aggregations, translation, etc) 
    // ...
    // ...
    // ...


    return em.createQuery(criteria).getResultList();
}
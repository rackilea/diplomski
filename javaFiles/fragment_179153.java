EntityManager em = entityManagerFactory.createEntityManager();

final List<ReportStatus> reportStatuses = new ArrayList<ReportStatus>();
reportStatuses.add(ReportStatus.FAILED);

final CriteriaBuilder builder = em.getCriteriaBuilder();

final CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
final Root<Work> _work = criteriaQuery.from(Work.class);

/*final ListJoin<Work, ReportStatus> status = _work.joinList("reportStatuses");
final Predicate predicate = status.in(reportStatuses);
criteriaQuery.where(predicate);*/

final Expression<List<ReportStatus>> _status = _work.get(Work_.reportStatuses);
_status.in(reportStatuses);

criteriaQuery.select(_work.get(Work_.id));

List<Long> list =  em.createQuery(criteriaQuery).getResultList();
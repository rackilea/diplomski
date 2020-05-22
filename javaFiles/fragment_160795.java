public boolean getAnalysisByUserId(final Integer userId) {
    Objects.requireNonNull(userId, "Integer userId cannot be null.");

final Query query = this.manager
    .createNativeQuery("select count(a.id) from AnalysisRequest a where a.userId = ?1");
query.setParameter(1, userId);

final Long result = (Long) query.getSingleResult();

return result != null && result > 0;
 }
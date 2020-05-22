// define query
CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
CriteriaQuery<TrainingHistory> query = cb.createQuery(TrainingHistory.class);
Root<TrainingHistory> root = query.from(TrainingHistory.class);
query.select(root);

// define subquery
Subquery<Integer> subquery = query.subquery(Integer.class);
Root<TrainingHistory> rootSubquery = subquery.from(TrainingHistory.class);
Expression<Integer> max = cb.max(rootSubquery.get(TrainingHistory_.DATE_DONE));
   subquery.select(max);
   subquery.groupBy(rootSubquery.get(TrainingHistory_.exercise));

// compose whole query
query.where(
   cb.and(
      cb.in(root.get(TrainingHistory_.DATE_DONE)).value(subquery),
      cb.equal(root.get(TrainingHistory_.ACCOUNT_ID), userId)
  )
);

return this.entityManager.createQuery(query).getResultList();
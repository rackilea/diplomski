CriteriaQuery<Tuple> cq = builder.createTupleQuery();
// write the Root, Path elements as usual
Root<EntityClazz> root = cq.from(EntityClazz.class);
cq.multiselect(root.get(EntityClazz_.ID), root.get(EntityClazz_.VERSION));  //using metamodel
List<Tuple> tupleResult = em.createQuery(cq).getResultList();
for (Tuple t : tupleResult) {
    Long id = (Long) t.get(0);
    Long version = (Long) t.get(1);
}
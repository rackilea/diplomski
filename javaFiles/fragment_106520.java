TypedQuery<MyEntity> query = em.createQuery("SELECT a FROM MyEntity a WHERE a.isEnable=0 ORDER BY a.id DESC", MyEntity.class);
query.setMaxResults(1);

List<MyEntity> resultList = query.getResultList();
if (resultList.size()>0) {
    resultList.get(0).setEnabled(true);
    //eventually you can to em.flush();
}
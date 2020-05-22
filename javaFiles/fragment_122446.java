List<Post> _posts = entityManager
.createQuery(
    "select distinct p " +
    "from Post p " +
    "left join fetch p.comments " +
    "where p.id between :minId and :maxId ", Post.class)
.setParameter("minId", 1L)
.setParameter("maxId", 50L)
.setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
.getResultList();
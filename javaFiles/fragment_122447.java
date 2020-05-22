_posts = entityManager
.createQuery(
    "select distinct p " +
    "from Post p " +
    "left join fetch p.tags t " +
    "where p in :posts ", Post.class)
.setParameter("posts", _posts)
.setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
.getResultList();
CriteriaQuery<Comment> cQuery =
        entityManager.getCriteriaBuilder()
                     .createQuery(Comment.class);
cQuery.select(cQuery.from(Customer.class)
                     .get(Customer_.comments));
List<Comment> comments = 
        entityManager.createQuery(cQuery)
                     .setFirstResult(0)
                     .setMaxResults(0)
                     .getResultList();
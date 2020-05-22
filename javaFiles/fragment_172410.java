List<Long> ids = em.createQuery("SELECT b.id FROM Books b WHERE b.author.id = :authorId", Long.class)
    .setParameter("authorId", authorId)
    .getResultList();
em.createQuery("UPDATE Books b SET b.bookTitle = :bookTitle WHERE b.id IN :ids")
    .setParameter("ids", ids)
    .setParameter("bookTitle", bookTitle)
    .executeUpdate();
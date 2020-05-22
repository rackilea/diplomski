Query q = em.createQuery(
        "select g "
        + "from Game g "
        + "join g.playedGames pga "
        + "join pga.account a "
        + "join g.playedGames pgp "
        + "join pgp.account p "
        + "where a = ?1 and p = ?2"
);
q.setParameter(1, a);
q.setParameter(2, p);
return q.getResultList();
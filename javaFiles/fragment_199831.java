Criteria gameCriteria = ((HibernateEntityManager) em).getSession().createCriteria(Game.class);

Criteria playedGamesOfACriteria = gameCriteria.createCriteria("playedGames", "pga");
Criteria accountOfACriteria = playedGamesOfACriteria.createCriteria("account", "a");
accountOfACriteria.add(Restrictions.idEq(a.id));

Criteria playedGamesOfPCriteria = gameCriteria.createCriteria("playedGames", "pgp");
Criteria accountOfPCriteria = playedGamesOfPCriteria.createCriteria("account", "p");
accountOfPCriteria.add(Restrictions.idEq(p.id));

return gameCriteria.list();
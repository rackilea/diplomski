session = getSession();
Transaction t = session.beginTransaction();
List<Player> result = session.createQuery("SELECT new Player(p.id, p.gm, p.name, p.loggedin) FROM Player p WHERE gm >= :level")
     .setParameter("level", PlayerGMLevelEnum.GM.getLevel())
     .getResultList();
 t.commit();
 session.close();
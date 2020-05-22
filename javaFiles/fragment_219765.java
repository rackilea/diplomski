entityManager.getTransaction().begin();
r = entityManager.find(Route.class, r.getPrimaryKey(), 
      LockModeType.PESSIMISTIC_READ);
//from this moment on we can safely read r again expect no changes
r.setRoute(txtRoute.getText());
entityManager.persist(r);
//When changes are flushed to database, provider must convert lock to 
//PESSIMISTIC_WRITE, which can fail if concurrent update
entityManager.getTransaction().commit();
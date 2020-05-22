EntityManager em = dao.getEntityManager();

Parent p = new Parent();

em.persist(p);

Child a = new Child(); a.setParent(p);
Child b = new Child(); b.setParent(p);
Child c = new Child(); c.setParent(p);

em.persist(a);
em.persist(b);
em.persist(c);
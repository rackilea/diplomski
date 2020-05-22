EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Parent p = new Parent(01,02);
    em.persist(p);
    Child c = new Child(02,"bob");
    em.persist(c);
    p.children = Collections.singleton(c); // connect the child to the parent

    em.getTransaction().commit();
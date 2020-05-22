PersonCassandra p = entityManager.find(PersonCassandra.class, "2");

        entityManager.getTransaction().begin();
        p.setMonth(Month.JAN);
        entityManager.merge(p);
        entityManager.persist(p3);
        entityManager.getTransaction().commit();
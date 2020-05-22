session = HibernateHelper.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Ent1 entity = new Ent1();
        entity.setA1(new Integer(0));
        entity.setA2(new Integer(1));
        session.save(entity);
        transaction.commit();

        // get saved object and modify it
        transaction = session.beginTransaction();
        List<Ent1> list = (List<Ent1>)session.createQuery("FROM Ent1 WHERE a1 = 0").list();
        Ent1 ent = list.get(0);
        ent.setA2(new Integer(1000));
        session.save(ent);
        transaction.commit();
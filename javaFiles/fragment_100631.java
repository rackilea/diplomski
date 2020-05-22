if (g != null) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        for (User u : g.getUsers()) {
            u.getGroups().remove(g);
        }
        g.getUsers().clear();
        session.delete(g);
        session.getTransaction().commit();
    }
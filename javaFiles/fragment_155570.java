try {
        session.beginTransaction();

        // your code

        session.getTransaction().commit();
    } catch (HibernateException e) {
        LOGGER.error(e);
        if (session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
    }
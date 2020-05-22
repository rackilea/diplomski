Session session = sf.openSession();
    Transaction tx = null;
    Integer templateID = null;

    Date date = new Date();

    try {
        tx = session.beginTransaction();
        Catalog catalog = new Catalog();
        //Business Logic
        templateID = (Integer) session.save(catalog);
    } catch (HibernateException ex) {
        if (tx != null) tx.rolback();
    } finally {
        session.close();
    }

    return templateID;
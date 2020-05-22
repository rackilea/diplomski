try {
        List<Cv> list;

        list = session.createCriteria(Cv.class).addOrder(Order.asc("id")).list();
        for(CV cv: list) {
           Hibernate.initialize(cv.getCertificates());
        } 

        if (session.isOpen()) {
            session.close();
        }

        return list;
    } catch (Exception e) {
        if (session.isOpen()) {
            session.close();
        }
        return null;
    }
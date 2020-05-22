Session session = this.sessionFactory.openSession();
    Transaction tx = null;
    try {
    tx = session.beginTransaction();
    for (StepFlow stepFlow : stepFlows) {

        session.save(stepFlow);

        session.flush();
        session.clear();
    }
    tx.commit();

    } catch (JDBCException e) {
        SQLException cause = (SQLException) e.getCause();
        System.out.println(cause.getMessage());

        tx.rollback();
    }finally{
        session.close();
    }
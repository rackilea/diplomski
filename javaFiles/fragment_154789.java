public static void main(String[] args) {
    Session session = null;
    Transaction tx = null;
    try {
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        Check c1=new Check();
        c1.setAmount(40555.4);
        c1.setBankId("AC11112");
        c1.setCheckNumber("CK12222CD");

        Check c2=new Check();
        c2.setAmount(50555.4);
        c2.setBankId("AC11111");
        c2.setCheckNumber("CK12233EW");

        session.persist(c1);//Insert check object c1
        session.persist(c2);//Insert check object c2

        tx.commit();
        System.out.println("After commit");
    } catch (RuntimeException e) {
        try {
            tx.rollback();
        } catch (RuntimeException rbe) {
            System.err.println("Couldn’t roll back transaction"+ rbe);
       }
        throw e;
    } finally{
        if(session != null){
            session.close();
        }
    }
    System.out.println("Success");
}
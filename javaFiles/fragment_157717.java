List<TestAuthor> listTA = new ArrayList<>();

    //create TestAuthor objects and add them to listTA       
    Session session = HibernateUtil.getCurrentSession();
    Transaction trx = session.beginTransaction();
    int i = 0;
    for( TestAuthor ta : listTA){

    session.persist(ta);
    //or session.save(ta);
    i++;
    if (i % 50 == 0) {
          session.flush();
          session.clear();
    }

    }
   trx.commit();
   session.close();
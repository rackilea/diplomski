Transaction tx=null;
      Session hSession=HibernateUtil.getSessionFactory().openSession();
      Query hQuery=hSession.createQuery("update Leaverecord set status='HR' where refId="+lrb.getRefId());
      System.out.println("Result : "+hQuery.executeUpdate());
      tx=hSession.beginTransaction();
      tx.commit();
        hSession.close();
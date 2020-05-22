try{
    session = sessionFactory.getCurrentSession();
    tx = session.getTransaction();
    criteria = session.createCriteria(Archive.class);
    criteria.add(Restrictions.eq("bagUuid",  "4a90558c-4a5b-4af7-8c68-60ff81f74ef3"));
    ScrollableResults items = criteria.scroll();

     while ( items.next() ) {
         Archive archive = (Archive)items.get();
         archive.setDecision(1);
         archive.setOperatorAssigned("test");
         session.saveOrUpdate(archive);
     }
     tx.commit();
     session.close();
    LOGGER.info("Archive Record is updated: "+archive.getFilePath());
}catch(Exception e){
    recordUpdated = false;
    tx.rollback();
    LOGGER.error("Archive Record failed to update due to exception in updateArchiveRecord method: "+e.getMessage());
}
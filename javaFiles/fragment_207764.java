public ItemType addItemType(String typeName) {
    Session session = factory.openSession();

    Transaction tx = null;
    ItemType itemType = null;
    try{
        tx = session.beginTransaction();
        itemType = session.createQuery("select it from ItemType where typeName = :typeName")
                   .setParameter("typeName", typeName)
                   .uniqueResult();
        if(itemType == null) {
            itemType = new ItemType();
            itemType.setTypeName(typeName);
            itemType.setDescription("");
            itemType.setCreatedBy("shoppingcart")    
            itemType.setCreatedDate(new Date());
        }
        itemType.setUpdatedBy("shoppingcart");
        itemType.setUpdatedDate(new Date());
        session.saveOrUpdate(itemType); 
        tx.commit();
    }catch (HibernateException e) {
        if (tx!=null) tx.rollback();
            e.printStackTrace(); 
    }finally {
        session.close(); 
    }
    return itemType;
}
//this is a update method
**public boolean updateImage(Image image) { 

    Session session = template.getSessionFactory().openSession();

    Transaction transaction = session.beginTransaction();

    session.saveOrUpdate(image);

    session.flush();

    transaction.commit();

    session.close();

    return true;
}**
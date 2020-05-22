Session session = getSession();                               
session.beginTransaction();                                                 

session.save(vendorRegistration);
session.getTransaction().commit();                           
session.close();
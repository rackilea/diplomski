session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();
 Movies newmovie= new Movies();
 newmovie.setMovie_name(data);
session.save(newmovie);
transaction.commit();
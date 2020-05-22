EntityManagerFactory eFactory = Persistence.createEntityManagerFactory("geronimo");
EntityManager eManager = eFactory.createEntityManager();
EntityTransaction eTransaction = eManager.getTransaction();
//eManager.persist(eTransaction); <--- DO NOT DO THIS
eTransaction.begin();
Discography discography = new Discography();
discography.setArtist("Kings Of Leon");
discography.setSong("Radioactive");
eManager.persist(discography); //  DO THIS INSTEAD. PERSIST THE ENTITY 
eTransaction.commit();
eManager.close();
eFactory.close();
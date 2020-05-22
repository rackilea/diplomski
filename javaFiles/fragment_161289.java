public Comics readComics(int random, String url){
    EntityManager em = EMF.get().createEntityManager();
    Comics comics = null;
   try{
        Query q = em.createNamedQuery("Comics.getComics");
        q.setParameter("random", random);
        q.setParameter("url", url);
        comics = (Comics) q.getSingleResult();

        Hibernate.initialize(comics.getUser());

    } catch(NoResultException ex){
        System.out.println("ERROR CATCHED: " + ex.getMessage());
        comics = null;
    } finally{
        em.close();
    }

    return comics;
}
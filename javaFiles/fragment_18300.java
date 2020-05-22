public class Resource {
    private EntityManagerFctory emf;

    @POST
    public Response get(Entity e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }
}
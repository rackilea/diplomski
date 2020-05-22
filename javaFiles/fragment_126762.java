@PersistenceUnit
public EntityManagerFactory emf;
public EntityManager em;




public EntityManager getEm() {
    emf = Persistence.createEntityManagerFactory("WebApplicationSecurityPU");
    em = emf.createEntityManager();
    return em;
}

public List fname (String id) {

    String fname = null;
    List persons = null;


    try {
        System.out.println("test");

        em = this.getEm();


        em.getTransaction().begin();
        int m = em.createQuery("update Roleuser r set r.firstName = 'Jignesh H' where r.userID=9").executeUpdate();

        em.getTransaction().commit();


    } catch(Exception e) {
        System.out.println("" + e);
    }
    finally {
        if(em != null) {
            em.close();
        }
    }
    return persons;
}
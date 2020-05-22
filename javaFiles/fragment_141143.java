@PersistenceUnit
public EntityManagerFactory emf;
EntityManager em;


public List fname (String id) {
    String fname = null;
    List persons = null;
    //private PersistenceManagerFactory persistenceManagerFactory;

    try {
        emf = Persistence.createEntityManagerFactory("WebApplicationSecurityPU");

        em = emf.createEntityManager();
        persons = em.createQuery("select r from Roleuser r").getResultList();

        int i=0;
        for (i=0;i<persons.size(); i++)
            System.out.println("Testing n "+ i +" " + persons.get(i));

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
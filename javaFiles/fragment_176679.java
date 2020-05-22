import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

public class CdiApplicationConfig {

    @Inject
    private EntityManagerFactory emf;

    @Produces
    @ApplicationScoped
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("generalPU");
        return emf;
    }

    public void close(@Disposes EntityManagerFactory emf) {
        emf.close();
    }

    @Produces
    @TransactionScoped // is a bit better than @RequestScoped because it won't allow perform injection outside transaction context
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
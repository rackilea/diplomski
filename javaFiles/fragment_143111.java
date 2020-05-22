import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

    @Entity
    public class Family {
        @Id
        int id;

        String name;

        @CollectionOfElements(targetElement = java.lang.String.class)
        @JoinTable(name = "elements_family",
                joinColumns = @JoinColumn(name = "idFamily")
        )
        @Column(name = "element", nullable = false)
        public List<String> elements;

        public static void main(String[] args) throws Exception {
            EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("mysql");
            EntityManager em = emf.createEntityManager();
            try {

                Family f1 = new Family();
                f1.id = 1;
                f1.name = "Happy";

                f1.elements = Arrays.asList("foo", "bar", "yyy", "zzz");

                Family f2 = new Family();
                f1.id = 2;
                f2.name = "Disfunctional";
                f2.elements = Arrays.asList("foo", "bar", "yyy", "xxx");

                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(f1);
                em.persist(f2);
                tx.commit();
                Query query = em.createQuery(
                   "select f from Family f WHERE :element in elements(f.elements)");
                query.setParameter("element", "bar");
                List list = query.getResultList();
                assert list.size() == 2;

            } finally {
                em.close();
                emf.close();
            }
        }
    }
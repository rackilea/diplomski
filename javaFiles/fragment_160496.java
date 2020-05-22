import java.util.List;
import javax.persistence.*;
import lombok.Data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
public class JpaMultikeyDemo {
    @Entity @Data
    public static class FooSequence {
        @Id @GeneratedValue private Long value;
    }

    @Entity @Data
    public static class FooEntity {
        @Id @GeneratedValue private Long id;
        @OneToOne           private FooSequence sequence;
    }

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void runInserts() {
        // Create ten objects, half with a sequence value
        for(int i = 0; i < 10; i++) {
            FooEntity e1 = new FooEntity();
            if(i % 2 == 0) {
                FooSequence s1 = new FooSequence();
                em.persist(s1);
                e1.setSequence(s1);
            }
            em.persist(e1);
        }
    }

    public void showAll() {
        String q = "SELECT e FROM JpaMultikeyDemo$FooEntity e";
        for(FooEntity e: em.createQuery(q, FooEntity.class).getResultList())
            System.out.println(e);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaMultikeyDemo.class);
        context.getBean(JpaMultikeyDemo.class).runInserts();
        context.getBean(JpaMultikeyDemo.class).showAll();
        context.close();
    }
}
package leader;

 import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class Test {

@PersistenceUnit(unitName="leader")
EntityManagerFactory emf1;


  public static void main(String[] args) {
    Project projectA = new Project();
    projectA.setId(1);


    Project projectB = new Project();
    projectB.setId(2);


    ProjectLeader leaderA = new ProjectLeader();
    leaderA.setId(1);

    ProjectLeader leaderB = new ProjectLeader();
    leaderB.setId(2);



    EntityManagerFactory emf =    Persistence.createEntityManagerFactory("leader");
    EntityManager em=emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(leaderA);
    em.persist(leaderB);

   // projectA.setProjectLeader(leaderA);
    projectA.setProjectLeader(leaderB);

    projectB.setProjectLeader(leaderA);
   // projectB.setProjectLeader(leaderB);


    em.persist(projectA);
    em.persist(projectB);
    em.getTransaction().commit();



  }

}
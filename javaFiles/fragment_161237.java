@Entity
@Table(name="PERSON")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="GENDER", discriminatorType=DiscriminatorType.STRING, length=6)
public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="PERSON_PERSONID_GENERATOR", sequenceName="PERSON_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSONID_GENERATOR")
    @Column(name="PERSON_ID", updatable=false, unique=true, nullable=false, precision=22)
    private long personId;

    @Column(nullable=false, length=32)
    private String surname;

    @Column(name="GIVEN_NAME", nullable=false, length=32)
    private String givenName;

    // ...
}


@Entity
@DiscriminatorValue("FEMALE")
public class Daughter extends Person implements Serializable {

    @Column(name="NUMBER_OF_DOLLS", precision=22)
    private int numberOfDolls;

    // ...
}


@Entity
@DiscriminatorValue("MALE")
public class Son extends Person implements Serializable {

    @Column(name="NUMBER_OF_TOY_CARS", precision=22)
    private Integer numberOfToyCars;

    // ...
}


// JUnit test method
public void testInheritance() {
    EntityManager em = createNewEntityManagerInstance();

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    Daughter d = new Daughter();
    d.setGivenName("Sue");
    d.setSurname("Smith");
    d.setNumberOfDolls(5);
    em.persist(d);
    Son s = new Son();
    s.setGivenName("Joe");
    s.setSurname("Smith");
    s.setNumberOfToyCars(8);
    em.persist(s);
    tx.commit();

    Query q;
    List<?> personList;
    Person p;

    q = em.createQuery("SELECT p FROM Person p WHERE TYPE(p) = Daughter");
    personList = q.getResultList();
    assertEquals(1, personList.size());
    p = (Person)personList.get(0);
    System.out.println(
        "This Daughter is: " + p.getGivenName() + " " + p.getSurname());
    q = em.createQuery("SELECT p FROM Person p WHERE TYPE(p) = Son");
    personList = q.getResultList();
    assertEquals(1, personList.size());
    p = (Person)personList.get(0);
    System.out.println(
        "This Son is: " + p.getGivenName() + " " + p.getSurname());
    q = em.createQuery("SELECT p FROM Person p");
    personList = q.getResultList();
    assertEquals(2, personList.size());
    for (Object o : personList) {
        assertTrue(o instanceof Person);
        p = (Person)o;
        System.out.println(
            "This person is: " + p.getGivenName() + " " + p.getSurname());
    }
    em.close();
}
public class DataGenerationTest {

private EntityManager em;

@Before 
public void init(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
    em = emf.createEntityManager();
}

@Test
public void shouldAddSomeCatalogs(){
em.getTransaction().begin();

Catalog catalog = new Catalog();
catalog.setProductName("Proguct");
catalog.setGenre(new Genre());
catalog.setType(new Type());
em.persist(catalog);
    em.getTransaction().commit();
    em.close();
}
}
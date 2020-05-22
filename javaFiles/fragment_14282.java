public class DonationsFacadeTest {


private EntityManager em; 
private EntityTransaction tx; 
DonationsFacade donations;

public DonationsFacadeTest() {
}

@Before
public void setUpClass() throws Exception {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Foundation2");
    em = emf.createEntityManager();
    tx = em.getTransaction(); 
    this.donations = new DonationsFacade(); 
    this.donations.em = em;
}

/**
 * Test of setPaid method, of class DonationsFacade.
 */
@Test
public void testSetPaid() throws Exception {

    int id = 1;
    String transId = "123";

    boolean expResult = false;
    boolean result = donations.setPaid(id, transId);
    assertEquals(expResult, result);

}
}
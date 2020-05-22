@RunWith(SpringRunner.class)
@DataJpaTest
public class MyJPAUnitTest extends SpringJpaUnitTestApplicationTests {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  CustomerRepository repository;

  @Test
  public void testExample() {...}
}
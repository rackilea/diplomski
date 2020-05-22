@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners({
  CassandraUnitTestExecutionListener.class,
  DependencyInjectionTestExecutionListener.class,
  DirtiesContextTestExecutionListener.class,
  TransactionalTestExecutionListener.class
})
@CassandraUnit
public class MyCassandraUnitTest {

  @Test
  public void xxx_xxx() {
  }
}
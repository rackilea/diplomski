@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TestExecutionListeners(
  listeners = CassandraUnitTestExecutionListener.class,
  mergeMode = MERGE_WITH_DEFAULTS
)
@CassandraUnit
public class MyCassandraUnitTest {

  @Test
  public void xxx_xxx() {
  }
}
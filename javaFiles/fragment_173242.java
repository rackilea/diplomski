public class LogConnectionTest extends AbstractSpringTest {

/** Instance to unit test. */
@Autowired
private LogConnectionDao logConnectionDao;

@Test
public void ajouterTest() {
    final LogConnection logConnection = logConnectionDao.saveAndFlush(new LogConnection("Test",4));
    Assert.assertNotNull(logConnection);
    Assert.assertEquals("Test", logConnection.getClasseName());
    Assert.assertNotEquals(5, logConnection.getOriginalId());
}
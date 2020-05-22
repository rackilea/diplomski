@ActiveProfiles("integration")
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/config/application-context.xml",
    "file:src/main/webapp/WEB-INF/config/AOP-context-config.xml"
})
public abstract class AbstractSpringTest extends Specification {

}



@Transactional("datawhseTransactionManager")
public class ControllerAspectsSpec extends AbstractSpringTest {

}
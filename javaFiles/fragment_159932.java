@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = DaemonApplication)
@ActiveProfiles('local')
//@SpringBootTest
@Transactional
public abstract class AbstractJpaTest extends AbstractTransactionalJUnit4SpringContextTests { 
    @BeforeTransaction
    public void setupData() throws Exception {
        deleteFromTables('User', 'User_Session', 'User_Handshake');
    }
}
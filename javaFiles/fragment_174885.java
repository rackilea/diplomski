@ContextConfiguration(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductManagerTest {

    @Autowired
    private ProductManager manager;

    @Test
    public void testSpringXMLConfiguration() {
    //use the productmanager in a test..
    }
}
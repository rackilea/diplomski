@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:your-test-context-xml.xml")
public class SpringJunitTests {

    @Autowired
    private Connection c;

    @Test
    public void tests() {
        assertEquals("arf arf arf", c.getX1();
    }

    // ...
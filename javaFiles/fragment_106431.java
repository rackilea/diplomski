@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({ "test" })
public class DummyTest {

    @Autowired
    private Environment env;

    @Test
    public void readProps() {
        String value = env.getProperty("prop1") + " " + env.getProperty("prop2");
        assertEquals("Hello World", value);
    }
}
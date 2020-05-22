@RunWith(SpringJunit4ClassRunner.class)
@ContextConfiguration(...)
public class FooDaoTest {
    @Autowired
    private FooDao fooDao;

    @Test
    public void testPersist() {
        // do some testing
    }
}
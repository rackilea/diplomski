@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, 
    value = "com.sample.AppConfig")
public class IocTest {
    @Autowired
    TestSerivce service;

    @Test
    public void testIoc()
    {
        Assert.assertNotNull(service.getPredicate());
    }
}
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(location={"classpath:location/of/your/spring.xml"})
public class MySpringTest {
    @Autowired
    Service service;

    @Test
    public void fooTest() {
        System.out.println(service.getId());
        Assert.assertEquals(100, service.getId());
    }
}
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test5.xml")
public class Test5 {
    @Autowired
    ConnectionFactory f1;

    @Test
    public void test() throws Exception {
...
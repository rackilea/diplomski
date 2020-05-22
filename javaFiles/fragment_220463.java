@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SomeBussinessTest {

    @Autowired
    SomeBussiness sbi;

    @Test
    public void findTheGreatestTest() {
        assertEquals(1, sbi.findTheGreatest());

    }
}
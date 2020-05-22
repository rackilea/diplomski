@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    ConfigProp configProp;

    @Test
    public void contextLoads() {
        assertEquals("abc", configProp.getCustUserName());
    }

}
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
public class MeTest {
    @Test
    public void testMe() {
        System.out.println("Hello World!");
    }
}
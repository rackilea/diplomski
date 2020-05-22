@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration")
public class DoNotStartMongoTest {
    //...

    @Test
    public void test() {
    }
}
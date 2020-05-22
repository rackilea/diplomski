@RunWith(PowerMockRunner::class)
@SpringBootTest
@ActiveProfiles("test")
public class SomeTest {
    @Inject
    private SomeClass someClass;

    @Inject
    private SomeWebserviceClient client; //<< will inject mock
}
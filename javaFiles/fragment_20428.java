@ContextConfiguration
@ActiveProfiles("anonymous_profile")
public class CsvResourceSplitterTest extends AbstractJUnit4SpringContextTests {
    @Profile("anonymous_profile")
    @Configuration
    static class Config {
...
}
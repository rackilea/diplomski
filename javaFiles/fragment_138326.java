@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyLibraryConfiguration.class}
public class SampleLibraryTest {

    @Autowired 
    private SomeBeanFromTheLibrary theBean;

    @Test
    public void testFoo() {
      ....
    }
}
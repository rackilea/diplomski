@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring.xml" })
public class ImgServiceImplTest {

    @Inject
    private ImgService imgService;

    private ImgServiceImpl imgServiceImpl;

    @PostConstruct
    public void setUp() {
        imgServiceImpl = getTargetObject(imgService, ImgServiceImpl.class);
    }


}
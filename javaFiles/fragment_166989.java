@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader=AnnotationConfigContextLoader.class)
public class TutorialTest {

    @Autowired
    private Dao dao;

    @Autowired
    private OuterService os;
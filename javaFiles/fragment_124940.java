@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@EnableConfigurationProperties(value = DecisionProposalProperties.class)
@SpringBootTest(classes = {
        DecisionProposalRepositoryService.class,
        DecisionProposalMapperImpl.class
})
public class DecisionProposalRepositoryServiceTest {

    @MockBean
    private DecisionProposalRepository decisionProposalRepository;

    @MockBean
    private CommentRepository commentRepository;

    @Autowired
    private DecisionProposalRepositoryService decisionProposalRepositoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /* Some tests here */

}
public class OrganizationServiceTest {

 private OrganizationRepository organizationRepository;

 private OrganizationServiceImpl organizationService;

 private OrganizationSearchRepository searchRepository;

 private OrganizationMapper organizationMapper = OrganizationMapper.INSTANCE;

 @Before
 public void setup() {
    organizationRepository = Mockito.mock(OrganizationRepository.class);
    searchRepository = Mockito.mock(OrganizationSearchRepository.class);
    organizationService = new OrganizationServiceImpl(organizationRepository, organizationMapper, searchRepository);
 }

 @Test
 public void testGetAllOrganization() {
    List<Organization> organizationList = Arrays.asList(organizationInit());

    when(organizationRepository.findAll()).thenReturn(organizationList);

    List<OrganizationDTO> result = organizationService.findAll();
    assertEquals(3, result.size());
 }
}
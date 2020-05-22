@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
public class PlayerControllerTest {
  private MockMvc mockMvc;

  @Mock
  private PlayerService playerService;

  @Autowired
  private PlayerController playerController;

  @Autowired
  private FilterChainProxy springSecurityFilterChain;

  @Test
  public void loadByAdmin()
  throws Exception {
    Player player = new player();
    when(playerService.getPlayers()).thenReturn(Collections.singletonList(player)); //success

    mockMvc.perform(get("/circuit/all").with(user("adm").password("123")
        .authorities(new SimpleGrantedAuthority("ADMIN")))
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    verify(playerService, times(1)).getPlayers(); //was called
    verifyNoMoreInteractions(playerService);  
  }


  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    this.mockMvc = MockMvcBuilders.standaloneSetup(playerController)
        .apply(springSecurity(springSecurityFilterChain)).build();

    ReflectionTestUtils.setField(playerController, "playerService", playerService);
}
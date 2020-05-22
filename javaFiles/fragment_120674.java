@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testAddUserToDb() throws Exception {
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");

        Gson gson = new Gson();
        String request = gson.toJson(user);

        //HERE I GET NULLPOINTEREXCEPTION
        when(userRepository.addUser(anyString(), anyString())).thenReturn(true);

        mockMvc.perform(post("user/add")
                .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));


        verify(userRepository, times(1)).addUser(anyString(), anyString());
        verifyNoMoreInteractions(userRepository);
    }
}
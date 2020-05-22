@RunWith(MockitoJUnitRunner.class)
public class ServiceTests {

    @InjectMocks
    private UserInfoService UserInfoService;

    @Mock
    private UserInfoServiceClient UserInfoServiceClient;

    @Test
    public void shouldReturnUserInfoData() throws IOException{
        final String userId = "123";
        // The mocked return value should be set up per test scenario
        final UserServiceDto dto = new UserServiceDto();
        final ResponseEntity<UserServiceDTO> mockedResp = new ResponseEntity<>(dto, HttpStatus.OK);

        // set up the mock service to return your response
        when(UserInfoServiceClient.sendResponse(userId)).thenReturn(mockedResp);

        // Call your service
        ResponseEntity<ResponseUserInfoData> resp = UserInfoService.sendUserInfo(userId);

        // Test the result
        Assert.isNotNull(resp);
    }
}
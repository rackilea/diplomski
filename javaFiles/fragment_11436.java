@RunWith(JunitMockitoRunner.class)
public class TestClass{

    @Spy
    private LoginInteractorImpl loginInterceptor=  new LoginInteractorImpl();

    @Mock
    private UserRepo mUserRepositoryMock;

    @Mock
    private Call<ResponseBody> mCallMock;

    @Mock
    private Credentials credentialsMock;

    public void shouldEnqueueWhenLogin(){
        // Arrange
        String username = "name";
        String password = "pass";
        Mockito.doReturn(mUserRepositoryMock).when(loginInterceptor).createClient();

       Mockito.doReturn(credentialsMock).when(loginInterceptor).when(getCredentials(username, password));

        Mockito.doReturn(mCallMock).when(mUserRepositoryMock).doLogin(credentialsMock);

        // Act
        loginInterceptor.login(username, password);

        // Assert that proper callback has been passed to enqueue
        verify(mCallMock).enqueue(Mockito.any(LoginCallback.class));
    }
 }
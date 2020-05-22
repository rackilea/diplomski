import static org.mockito.Mockito.*;
import mypkg.Service;
import mypkg.User;
import mypkg.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.security.Principal;

public class ServiceTest {

    @Spy
    @InjectMocks
    private Service service;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Principal principal;

    @Mock
    private User userStub;

    private String defaultName = "name";

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

   @org.junit.Test
   public void shouldReturnTrue_whenUserDeleted() throws Exception{
       // Arrange
       when(principal.getName()).thenReturn(defaultName);
       when(service.findUserbyUsername(defaultName)).thenReturn(userStub);

       // Act
       boolean removed = service.deleteUser(principal);

       // Assert
       Assert.assertTrue(removed);
       verify(userRepository, times(1)).delete(userStub);
   }

    @org.junit.Test
    public void shouldReturnFalse_whenUserNotFound() throws Exception{
        // Arrange
        when(principal.getName()).thenReturn(defaultName);
        when(service.findUserbyUsername(defaultName)).thenReturn(null);

        // Act
        boolean removed = service.deleteUser(principal);

        // Assert
        Assert.assertFalse(removed);
        verify(userRepository, times(0)).delete(userStub);
    }
}
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;    
import java.net.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
//This tells powermock that we will modify MyClass.class in this test 
//- needed for changing the call to new URL
@PrepareForTest(MyClass.class) 
public class ConnectionTimeOutTest {

String url = "http://example.com";
@Test
public void timeout() throws Exception{
    //create a mock URL and mock HttpURLConnection objects
    //that will be our simulated server
    URL mockURL = PowerMockito.mock(URL.class);
    HttpURLConnection mockConnection = PowerMockito.mock(HttpURLConnection.class);

    //powermock will intercept our call to new URL( url) 
    //and return our mockURL object instead!
    PowerMockito.whenNew(URL.class).withArguments(url).thenReturn(mockURL);
    //This tells our mockURL class to return our mockConnection object when our client
    //calls the open connection method
    PowerMockito.when(mockURL.openConnection()).thenReturn(mockConnection);



    //this is our exception to throw to simulate a timeout
    SocketTimeoutException expectedException = new SocketTimeoutException();

    //tells our mockConnection to throw the timeout exception instead of returnig a response code
    PowerMockito.when(mockConnection.getResponseCode()).thenThrow(expectedException);

    //now we are ready to actually call the client code
    // cut = Class Under Test
    MyClass cut = new MyClass();

    //our code should catch the timeoutexception and return false
    assertFalse(cut.foo());

   // tells mockito to expect the given void methods calls
   //this will fail the test if the method wasn't called with these arguments
   //(for example, if you set the timeout to a different value)
    Mockito.verify(mockConnection).setRequestMethod("HEAD");
    Mockito.verify(mockConnection).setConnectTimeout(5000);

}
}
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SomeClass.class)
public class SomeClassTest {

    private SomeClass someInstance;

    @Before
    public void setUp() throws Exception {

        someInstance = PowerMockito.spy(new SomeClass());
    }

    @Test
    public void sendRequest() throws Exception {

        String json = "JSON";
        String text = "Some text";
        int messageId = 1;

        PowerMockito.doReturn(true).when(someInstance, "isMethod");
        PowerMockito.doReturn(messageId).when(someInstance, "getMessageId", json);

        someInstance.sendRequest(json, text);

        PowerMockito.verifyPrivate(someInstance).invoke("isMethod");
        PowerMockito.verifyPrivate(someInstance).invoke("getMessageId", json);
        PowerMockito.verifyPrivate(someInstance).invoke("sendMessage", messageId, text);
    }

}
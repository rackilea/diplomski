import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MultipleMethodCallTest {

    @Spy
    A a = new A();

    @Captor ArgumentCaptor<String> captor;

    @Test
    public void captureSecondMethodCallArgument() throws Exception {

        // EXPECTED

        String greeting = "hello world";

        // PERFORM TEST

        a.methodA(greeting);

        // ASSERT

        verify(a).methodB(captor.capture());

        assertEquals(greeting, captor.getValue());
    }
}
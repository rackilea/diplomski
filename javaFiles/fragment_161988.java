import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.easymock.IAnswer;
import org.junit.Ignore;
import org.junit.Test;

public class SomeTest extends AbstractUiTest {
    @Test
    public void shouldCallShowNotification() {
        final AtomicBoolean showNotificationCalled = new AtomicBoolean();
        expect(page.showNotification()).andAnswer(new IAnswer<String>() {
            @Override
            public String answer() {
                showNotificationCalled.set(true);
                return "";
            }
        });

        replay(page);
        Ui.getCurrentPage();
        verify(page);

        assertTrue("showNotification not called", showNotificationCalled.get());
    }
}
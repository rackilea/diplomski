import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.easymock.IAnswer;
import org.junit.Ignore;
import org.junit.Test;

public class SomeTest extends AbstractUiTest {
    @Test
    public void shouldCallShowNotification() {
        final AtomicBoolean showNotificationCalled = new AtomicBoolean();
        page.showNotification();
        expectLastCall().andAnswer(new IAnswer<Void>() {
            @Override
            public Void answer() {
                showNotificationCalled.set(true);
                return null;
            }
        });

        replay(page);
        Ui.getCurrentPage();
        verify(page);

        assertTrue("showNotification not called", showNotificationCalled.get());
    }
}
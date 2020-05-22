import org.tanukisoftware.wrapper.event.WrapperEvent;
import org.tanukisoftware.wrapper.event.WrapperEventListener;
import org.tanukisoftware.wrapper.event.WrapperServiceControlEvent;


public class LoginListener implements WrapperEventListener
{
    public LoginListener() { }

    public void fired( WrapperEvent event ) {
        if (event instanceof WrapperServiceControlEvent) {
            WrapperServiceControlEvent scEvent = (WrapperServiceControlEvent) event;
            switch (scEvent.getServiceControlCode()) {
                case 155:
                    // LoginServiceDefer has sent a control code.
                    break;
            }
        }
    }
}
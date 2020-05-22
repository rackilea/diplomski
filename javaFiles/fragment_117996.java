import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class HTTPClient extends UiApplication {
    private LabelField labelField;

    public static void main(String[] args) {
        HTTPClient theApp = new HTTPClient();
        theApp.enterEventDispatcher();
    }

    public HTTPClient() {
        MainScreen httpScreen = new MainScreen();
        labelField = new LabelField();
        httpScreen.add( labelField);
        pushScreen(httpScreen);

        new Thread() {
            public void run() {
                getPage("http://google.com");
            }
        }.start();
    }

    public void getPage(String url) {
        try {
            StreamConnection s = (StreamConnection) Connector.open(url);
            InputStream input = s.openInputStream();
            byte[] data = new byte[256];
            int len = 0;
            StringBuffer raw = new StringBuffer();
            while (-1 != (len = input.read(data))) {
                raw.append(new String(data, 0, len));
            }
            input.close();
            s.close();

            show(raw.toString());

        } catch (Exception e) {
        }
    }

    public void show(final String response) {
        Thread t = new Thread() {
            public void run() {
                labelField.setText(response);
            }
        };
        UiApplication.getUiApplication().invokeLater(t);
    }
}
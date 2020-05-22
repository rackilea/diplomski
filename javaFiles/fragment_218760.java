import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface MyClientBundle extends ClientBundle {

    public static final MyClientBundle INSTANCE = GWT.<MyClientBundle>create(MyClientBundle.class);

    @Override @Source("path/to/myStyleSheet.css") MyCssResource myCssResource();
}
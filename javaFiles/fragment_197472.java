import java.net.URL;

import javafx.fxml.FXMLLoader;


public interface CustomComponent {
    public default void loadFXML(String fxml) {
        try {
            URL resource = getClass().getResource(fxml);
            FXMLLoader loader = new FXMLLoader(resource);
            loader.setRoot(this);
            loader.setController(this);
            loader.load();
        } catch (Exception exc) {
            if (! (exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            } else {
                throw (RuntimeException)exc ;
            }
        }
    }
}
import java.util.Date;
import javafx.concurrent.Task;

class BgrdTask extends Task<String> {
    @Override protected String call() throws Exception {
        return new Date().toString();
    }
}
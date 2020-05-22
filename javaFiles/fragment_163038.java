public class ShutDown implements Runnable{

private static final org.slf4j.Logger log = LoggerFactory.getLogger(ShutDown.class);

private static final String SHUTDOWNCOOKIE = "switchoff";

public void run() {
    try {
        URL url = new URL("http://localhost:8080/shutdown?token=" + SHUTDOWNCOOKIE);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.getResponseCode();
        String attempt = "Shutting down " + url + ": " + connection.getResponseMessage();  
        log.info(attempt);
    } catch (Exception e) {
        String error = "Error " + e.getMessage(); 
        log.debug(error);
    }
}
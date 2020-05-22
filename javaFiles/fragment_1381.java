public class UploadHDFS {
public static void main(String[] args) throws Exception {
    new UploadHDFS().execute();
}

public void execute() {
    String configurationLocation = System.getProperty("oozie.action.conf.xml");
    Path localConfigurationPath = new Path(configurationLocation);
    Configuration configuration = new Configuration();
    configuration.addResource(localConfigurationPath);
    // .. continue here 
    }
}
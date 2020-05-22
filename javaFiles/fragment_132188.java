package beans;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class CustomXMLConfiguration extends XMLConfiguration {

    private String loadFileName;

    private void init() throws ConfigurationException {
        this.load(fileName);
    }

    public String getLoadFileName() {
        return loadFileName;
    }

    public void setLoadFileName(String fileName) {
        this.loadFileName = fileName;
    }
}
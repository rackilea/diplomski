import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class LoggingErrorHandler implements ErrorHandler {

    private boolean isValid = true;

    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public void warning(SAXParseException exc) {
        // log info
        // valid or not?
    }

    @Override
    public void error(SAXParseException exc) {
        // log info
        this.isValid = false;
    }

    @Override
    public void fatalError(SAXParseException exc) throws SAXParseException {
        // log info
        this.isValid = false;
        throw exc;
    }
}
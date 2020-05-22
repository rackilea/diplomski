import java.util.logging.Logger; 

public class Test { 
private Logger LOG = Logger.getLogger(""); 

    public void main(String[] args) {
        try {
            doStuff();
        } catch (SomeException e) { // HERE VIOLATION
            handleException(e);
        }
        try { 
            doStuff(); 
        } catch (SomeException e) { 
            LOG.info(e.getMessage() + " other stuff"); 
            handleException(e); 
        }
    }
}
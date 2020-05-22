// Note, no import of javax.servlet.http.HttpSessionContext
import javax.servlet.http.HttpSession;

@SuppressWarnings("deprecation")
public class MySession implements HttpSession {

    /**
     * This javadoc comment, along with the fully qualified name of HttpSessionContex in the method signature seems to do the trick.
     * @deprecated
     */
    public javax.servlet.http.HttpSessionContext getSessionContext() {
    }

    //... All your other methods
}
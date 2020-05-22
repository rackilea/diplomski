import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OSXAdapter implements InvocationHandler {

    private OSXQuitListener _quitListener;
    private OSXAboutListener _aboutListener;
    private OSXPreferenceListener _perferenceListener;

    /**
     * creates this adapter, only does stuff when we're on a mac, if it's unable to
     * register the quit adapter, then we throw an exception.
     *
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public OSXAdapter() throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

        // get's the os name
        String vers = System.getProperty("os.name").toLowerCase();

        // only attempt to the do the following if we're on a mac
        if (vers.indexOf("mac") != -1) {
            Class quitHandlerClass = Class.forName("com.apple.mrj.MRJQuitHandler");
            Class aboutHandlerClass = Class.forName("com.apple.mrj.MRJAboutHandler");
            Class prefHandlerClass = Class.forName("com.apple.mrj.MRJPrefsHandler");

            Class mrjapputilsClass = Class.forName("com.apple.mrj.MRJApplicationUtils");
            Object methodHandler = Proxy.newProxyInstance(quitHandlerClass.getClassLoader(), new Class[] { quitHandlerClass, aboutHandlerClass, prefHandlerClass }, this);

            Method appUtilsObj = mrjapputilsClass.getMethod("registerQuitHandler", new Class[] { quitHandlerClass });
            appUtilsObj.invoke(null, new Object[] { methodHandler });

            appUtilsObj = mrjapputilsClass.getMethod("registerAboutHandler", new Class[] { aboutHandlerClass });
            appUtilsObj.invoke(null, new Object[] { methodHandler });

            appUtilsObj = mrjapputilsClass.getMethod("registerPrefsHandler", new Class[] { prefHandlerClass });
            appUtilsObj.invoke(null, new Object[] { methodHandler });

        }
    }

    /**
     * registers an about dialog. When the os x system fires the event which
     * triggers an about class
     * 
     * @param listener
     */
    public void setAboutListener(OSXAboutListener listener) {
        _aboutListener = listener;
    }

    /**
     * registers an preference listener. When the os x fires the preference event this will be
     * fired.
     * 
     * @param listener
     */
    public void setPerferenceListener(OSXPreferenceListener listener) {
        _perferenceListener = listener;
    }

    /**
     * register an quit listener. When the os x fires the quit event this will be
     * fired.
     *
     * @param listener
     */
    public void setQuitListener(OSXQuitListener listener) {
        _quitListener = listener;
    }

    /**
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
     *      java.lang.reflect.Method, java.lang.Object[])
     */
    public Object invoke(Object proxy, Method meth, Object[] args) throws Throwable {
        if (meth.getName().equals("handleQuit")) {
            if (null != _quitListener) {
                _quitListener.handleQuit();
            }
        } else if (meth.getName().equals("handleAbout")) {
            if (null != _aboutListener) {
                _aboutListener.handleAbout();
            }
        } else if (meth.getName().equals("handlePrefs")) {
            if (null != _perferenceListener) {
                _perferenceListener.handlePrefs();
            }
        }

        return null;
    }

    /**
    * listener which listens to the about event from the os x
    * system
    *
    * @author Chris Shorrock
    */
    public interface OSXAboutListener {

    /**
    * handles the about display event.
    */
    public void handleAbout();

    }



    /**
    * this listener is fired when the os x system quits
    *
    * @author Chris Shorrock
    */
    public interface OSXQuitListener {

    /**
    * this method is called when os x tells this application
    * to quit.
    */
    public void handleQuit();
    }



    /**
    * this listener is fired when the os x system fires preferences
    *
    * @author Chris Shorrock
    */
    public interface OSXPreferenceListener {

    /**
    * this method is called when os x tells this application
    * to open preferences.
    */
    public void handlePrefs();
    }
}
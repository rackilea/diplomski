import core.util.MethodInvoker;

public abstract class AbstractSwingMethodInvoker extends MethodInvoker implements Runnable {

    private Object result;

    public AbstractSwingMethodInvoker(Object parent, Class parentClass, String methodName) {

        super(parent, parentClass, methodName);


    }

    public AbstractSwingMethodInvoker(Object parent, String methodName) {

        this(parent, parent.getClass(), methodName);

    }

    public AbstractSwingMethodInvoker(Class clazz, String methodName) {

        this(null, clazz, methodName);

    }

    @Override
    public void run() {

        result = super.execute();

    }

    public Object getResult() {

        return result;

    }

    public class SynchronisedDispatcherException extends Error {

        public SynchronisedDispatcherException(String message) {
            super(message);
        }

        public SynchronisedDispatcherException(String message, Throwable cause) {
            super(message, cause);
        }

    }

}
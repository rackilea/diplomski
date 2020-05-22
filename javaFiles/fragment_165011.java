import javax.swing.SwingUtilities;

/**
 * This will place the method call onto the end of the event dispatching
 * queue and return immediately.
 * 
 * There is no means to known when the call actually takes and place and if
 * you are interested in the return result, you are better of using InvokeAndWait
 * @author shane
 */
public class InvokeAfter extends InvokeLater {

    public InvokeAfter(Object parent, Class parentClass, String methodName) {

        super(parent, parentClass, methodName);

    }

    public InvokeAfter(Object parent, String methodName) {

        this(parent, parent.getClass(), methodName);

    }

    public InvokeAfter(Class clazz, String methodName) {

        this(null, clazz, methodName);

    }

    @Override
    public Object execute() throws SynchronisedDispatcherException {

        SwingUtilities.invokeLater(this);

        return null;

    }
}
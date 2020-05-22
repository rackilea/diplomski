import java.awt.EventQueue;
import javax.swing.SwingUtilities;

/**
 * This will make a synchronised call into the EventQueue.
 * 
 * There is no way to determine when the actually call will be made.  If you
 * need to wait for the result of the call, you are better  of using 
 * InvokeAndWait instead
 * 
 * If the invoke method is called within the ETD, it will be executed
 * immediately.
 * 
 * If you want the call to occur later (ie have it placed at the end
 * of the EventQueue, use InvokeAfter)
 * 
 * The invoke method will always return null.
 * @author shane
 */
public class InvokeLater extends AbstractSwingMethodInvoker {

    public InvokeLater(Object parent, Class parentClass, String methodName) {

        super(parent, parentClass, methodName);

    }

    public InvokeLater(Object parent, String methodName) {

        this(parent, parent.getClass(), methodName);

    }

    public InvokeLater(Class clazz, String methodName) {

        this(null, clazz, methodName);

    }

    @Override
    public Object execute() throws SynchronisedDispatcherException {

        if (EventQueue.isDispatchThread()) {

            run();

        } else {

            SwingUtilities.invokeLater(this);

        }

        return null;

    }

}
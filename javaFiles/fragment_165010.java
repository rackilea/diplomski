import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

public class InvokeAndWait extends AbstractSwingMethodInvoker {

    public InvokeAndWait(Object parent, Class parentClass, String methodName) {

        super(parent, parentClass, methodName);

    }

    public InvokeAndWait(Object parent, String methodName) {

        this(parent, parent.getClass(), methodName);

    }

    public InvokeAndWait(Class clazz, String methodName) {

        this(null, clazz, methodName);

    }

    @Override
    public Object execute() {

        if (EventQueue.isDispatchThread()) {

            run();

        } else {

            try {

                SwingUtilities.invokeAndWait(this);

            } catch (InterruptedException ex) {

                throw new InvocationException("Failed to invokeAndWait", ex);

            } catch (InvocationTargetException ex) {

                throw new InvocationException("Failed to invokeAndWait", ex);

            }

        }

        return getResult();

    }

}
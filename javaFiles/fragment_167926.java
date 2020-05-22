import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.widgets.*;

/*
 * This example demonstrates the minimum amount of code required
 * to open an SWT Shell and process the events.
 */
public class HelloWorld1 {

public static void main (String [] args) {
    Display display = new Display ();
    Shell shell = new HelloWorld1 ().open (display);
    while (!shell.isDisposed ()) {
        if (!display.readAndDispatch ()) display.sleep ();
    }
    display.dispose ();
}

public Shell open (Display display) {
    Shell shell = new Shell (display);
    MyComposite parent = new MyComposite(shell, SWT.NONE);
    parent.addChildEventListener(new ChildEventListener() {

        @Override
        public void add(ChildEvent e) {
            System.out.println("Child added.");

        }
    });
    MyComposite child = new MyComposite(parent, SWT.NONE);

//  shell.open ();
    return shell;
}
}

class MyComposite extends Composite {

    ChildEventListener[] childEventListeners = new ChildEventListener[0];

    public MyComposite(Composite parent, int style) {
        super(parent, style);
        if (parent instanceof MyComposite){
            ((MyComposite)parent).fireChildEvent(new ChildEvent(this));
        }
    }
    public void addChildEventListener (ChildEventListener listener) {
        checkWidget();
        if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
        ChildEventListener[] newChildEventListeners = new ChildEventListener[childEventListeners.length + 1];
        System.arraycopy(childEventListeners, 0, newChildEventListeners, 0, childEventListeners.length);
        childEventListeners = newChildEventListeners;
        childEventListeners[childEventListeners.length - 1] = listener;
    }
    public void removeChildEventListener (ChildEventListener listener) {
        if (childEventListeners.length == 0) return;
        int index = -1;
        for (int i = 0; i < childEventListeners.length; i++) {
            if (listener == childEventListeners[i]){
                index = i;
                break;
            }
        }
        if (index == -1) return;
        if (childEventListeners.length == 1) {
            childEventListeners = new ChildEventListener[0];
            return;
        }
        ChildEventListener[] newChildEventListeners = new ChildEventListener[childEventListeners.length - 1];
        System.arraycopy (childEventListeners, 0, newChildEventListeners, 0, index);
        System.arraycopy (childEventListeners, index + 1, newChildEventListeners, index, childEventListeners.length - index - 1);
        childEventListeners = newChildEventListeners;
    }
    public void fireChildEvent(ChildEvent event){
        for (int i = 0; i < childEventListeners.length; i++) {
            childEventListeners[i].add (event);
        }

    }
}

interface ChildEventListener extends SWTEventListener {
    public void add(ChildEvent e);
}

class ChildEvent extends TypedEvent {

    public ChildEvent(Widget widget) {
        super(widget);
        // TODO Auto-generated constructor stub
    }

}
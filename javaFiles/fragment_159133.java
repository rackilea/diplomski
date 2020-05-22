import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class MiniExample {

    public static void main(String[] args) {
        Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        StyledTextWithListeners text = new StyledTextWithListeners(shell, SWT.BORDER);

        text.setText("TEXT");

        text.addListenerByUser(SWT.Verify, new Listener() {

            @Override
            public void handleEvent(Event arg0) {

            }
        });

        text.removeAllListeners();

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public static class StyledTextWithListeners extends StyledText
    {
        HashMap<Integer, Listener> listeners;
        public StyledTextWithListeners(Composite parent, int style) {
            super(parent, style);
        }

        public void addListenerByUser(int eventType, Listener listener)
        {
            addListener(eventType, listener);
            System.out.println("Adding: " + listener.getClass().toString());

            if(listeners == null)
                listeners = new HashMap<Integer, Listener>();

            listeners.put(eventType, listener);
        }

        public void removeAllListeners()
        {
            for(Integer type : listeners.keySet())
            {
                System.out.println("Removing: " + listeners.get(type).getClass().toString());
                removeListener(type.intValue(), listeners.get(type));
            }
            listeners = new HashMap<Integer, Listener>();
        }
    }
}
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class MiniExample {

    public static void main(String[] args) {
        Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        // Fill your ArrayList with its content
        ArrayList<String> printer = new ArrayList<String>();
        printer.add("Epson");
        printer.add("Canon");
        printer.add("HP");

        final List printerList = new List(shell, SWT.MULTI | SWT.BORDER);

        // Fill the ArrayList into the SWT List
        for(String print : printer)
            printerList.add(print);

        // Print selection
        printerList.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                if(printerList.getSelectionCount() > 0)
                    System.out.println(Arrays.toString(printerList.getSelection()));
            }
        });

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
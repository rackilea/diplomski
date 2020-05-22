package javaTools;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class WBTest {
    private Table table;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        try {
            WBTest window = new WBTest();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display.setAppName("myapplication");
        Display display = Display.getDefault();
        Display.setAppName("myapplication");
        Shell shell = new Shell();
        shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
        shell.setSize(560, 426);
        shell.setText("SWT Application");

        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
        // table.setBounds(49, 21, 241, 158);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableItem row = new TableItem(table, SWT.NONE);
        row.setText("This is a test.");


        shell.open();
        // shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}
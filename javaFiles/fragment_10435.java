import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

public class MenuTest {

    public static void main (String [] args) 
    {
        Display display = new Display ();
        final Shell shell = new Shell (display);

        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        layout.numColumns = 1;
        shell.setLayout(layout);
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true));
        final Menu bar = new Menu (shell, SWT.BAR);
        shell.setMenuBar (bar);

        shell.addShellListener(new ShellListener() {

            public void shellIconified(ShellEvent e) {
            }
            public void shellDeiconified(ShellEvent e) {
            }
            public void shellDeactivated(ShellEvent e) {
            }
            public void shellClosed(ShellEvent e) {
                System.out.println("Client Area: " + shell.getClientArea());
            }
            public void shellActivated(ShellEvent e) {
                int frameX = shell.getSize().x - shell.getClientArea().width;
                int frameY = shell.getSize().y - shell.getClientArea().height;
                shell.setSize(300 + frameX, 250 + frameY);
            }
        });     

        shell.open ();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }
}
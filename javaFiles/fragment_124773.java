import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

    public static int WIDTH=500;
    public static int HEIGHT=70;
    public static void main (String [] args) {
        Display display = new Display ();
        Shell shell = new Shell(display);
        shell.setSize(WIDTH,HEIGHT);
        shell.setLayout(new GridLayout());
        shell.setBackground(display.getSystemColor(SWT.COLOR_RED));
        create(shell);


        shell.pack();
        shell.open ();
        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }


    private static void create(Shell shell){
        Canvas c= new Canvas(shell, SWT.DOUBLE_BUFFERED);
        GridData gd= new GridData();
        gd.heightHint=HEIGHT-30;
        gd.widthHint=WIDTH-30;
        c.setLayoutData(gd);
        c.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TRANSPARENT));
        c.setBackgroundMode(SWT.INHERIT_FORCE);
        c.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
                Rectangle clientArea = c.getClientArea();
                e.gc.setAlpha(100);
                e.gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
                e.gc.fillRectangle(clientArea.x,clientArea.y,clientArea.width-1,clientArea.height-1);
            }
        });
    }

}
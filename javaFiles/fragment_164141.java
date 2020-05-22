import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.POINT;
import org.eclipse.swt.internal.win32.RECT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ShellBorder {

    private Display display = new Display();
    private Shell shell = new Shell(display);
    private RECT currRect = null;
    private Shell paintShell = null;

    public ShellBorder() {

        shell.addListener(SWT.MouseUp, new Listener() {

            @Override
            public void handleEvent(Event event) {
                paintShell.dispose();

                // do whatever you need
                // ...

                currRect = null;
            }
        });

        shell.addListener(SWT.MouseMove, new Listener() {
            @Override
            public void handleEvent(Event event) {
                final Point displayPoint = display.map(shell, null, event.x, event.y);
                final POINT point = new POINT();
                point.x = displayPoint.x;
                point.y = displayPoint.y;
                if(currRect == null) {
                    getWindowAndDrawBorder(point);
                } else {
                    // cursor is outside the current rectangle
                    if (point.x < currRect.left || point.x > currRect.right || point.y < currRect.top || point.y > currRect.bottom) {
                        currRect = null;
                        paintShell.dispose();
                        getWindowAndDrawBorder(point);
                    }
                }
            }

            private void getWindowAndDrawBorder(POINT point) {
                long windowHandle = OS.WindowFromPoint(point);
                if (windowHandle != 0 && windowHandle != shell.handle) {
                    RECT rect = new RECT();
                    if (OS.GetWindowRect(windowHandle, rect)) {
                        currRect = rect;

                        paintShell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
                        paintShell.setLocation(currRect.left, currRect.top);
                        paintShell.setSize(currRect.right - currRect.left, currRect.bottom - currRect.top);
                        paintShell.setLayout(new FillLayout());
                        paintShell.setAlpha(50);

                        Canvas canvas = new Canvas(paintShell, SWT.NO_BACKGROUND);
                        canvas.addPaintListener(new PaintListener() {
                            public void paintControl(PaintEvent e) {
                                GC gc = e.gc;
                                gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
                                gc.setLineWidth(5);
                                gc.drawRectangle(new Rectangle(0, 0, paintShell.getSize().x, paintShell.getSize().y));
                            }
                        });
                        paintShell.open();
                    }
                }
            }
        });

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

    }

    public static void main(String[] args) {
        new ShellBorder();
    }
}
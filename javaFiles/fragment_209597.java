import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ImageGradientTest {

    private Image imageGradient;
    private Image image;

    private void createComponents(Shell parent) 
    {
        ScrolledComposite sc = new ScrolledComposite(parent, SWT.BORDER_SOLID | SWT.V_SCROLL);
        sc.setExpandHorizontal(true);
        sc.setExpandVertical(true);

        sc.setAlwaysShowScrollBars(true);
        sc.setMinWidth(0);

        GridData gd = new GridData(GridData.FILL, GridData.FILL, true, true);
        sc.setLayoutData(gd);
        sc.setLayout(new GridLayout(1, false));


        final Composite composite = new Composite(sc, SWT.NONE);
        composite.addListener(SWT.Resize, new Listener() {
            public void handleEvent(Event e) {
                changeImage(composite);
            }
        });
        composite.setLayout(new FormLayout());
        composite.setBackgroundMode(SWT.INHERIT_DEFAULT);

        Label label = new Label(composite, SWT.None);
        label.setText("Hello, World!");

        sc.setContent(composite);
        sc.layout();

    }

    private void changeImage(Composite composite) 
    {
        Image oldImage = imageGradient;

        Display display = composite.getDisplay();
        Rectangle rect = composite.getClientArea();
        imageGradient = new Image(display, image, SWT.IMAGE_COPY);


        GC gc = new GC(imageGradient);
        Color color1 = new Color(display, 200, 200, 255);
        Color color2 = new Color(display, 255, 255, 255);

        gc.setAlpha(245);           // Two have a layer effect you should set the alpha
        gc.setForeground(color1);
        gc.setBackground(color2);
        gc.fillGradientRectangle(rect.x, rect.y, rect.width, rect.height, true);

        color2.dispose();
        color1.dispose();
        gc.dispose();


        composite.setBackgroundImage(imageGradient);

        if (oldImage != null) {
            oldImage.dispose();
        }
    }

    private void openShell() 
    {
        Display display = new Display();

        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        image = new Image(display, "image.png");

        shell.setBackgroundImage(image);
        shell.setBackgroundMode(SWT.INHERIT_DEFAULT);

        createComponents(shell);

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        image.dispose();
        imageGradient.dispose();        
        display.dispose();
    }

    public static void main(String[] args) {
        ImageGradientTest sweet = new ImageGradientTest();
        sweet.openShell();
    }
}
package org.mypackage.program;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class Demo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            Display display = new Display();
            Shell shell = new Shell(display);
            Image img;
            shell.setMaximized(true);
            img= new Image(display,".\\src\\org\\mypackage\\program\\car_image.gif");
            Composite comp= new Composite(shell, SWT.NONE);
            comp.setBackgroundImage(img);
            shell.setLayout(new FillLayout());
            shell.open();
            while (!shell.isDisposed())
            {       
                if (!display.readAndDispatch())
                {         
                    display.sleep();       
                }     
            }     
            display.dispose();
    }
}
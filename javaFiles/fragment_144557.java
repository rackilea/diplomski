import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

class TestTab extends Composite 
{
    Button upperButton = null;
    Text textInTheMiddle = null;
    Button lowerButton = null;

    boolean state = true;

    public TestTab(Composite parent, int style) 
    {
        super(parent, style);


        GridLayout layout = new GridLayout(1, false);
        setLayout(layout);


        upperButton = new Button(this, SWT.PUSH);
        upperButton.setText("upper Button");

        textInTheMiddle = new Text(this, SWT.BORDER);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
        data.exclude = false;
        textInTheMiddle.setLayoutData(data);

        lowerButton = new Button(this, SWT.PUSH);
        lowerButton.setText("lower Button");

        upperButton.addSelectionListener(new SelectionAdapter() 
        {
            public void widgetSelected(SelectionEvent e) {


                GridData griddata = (GridData) textInTheMiddle.getLayoutData();
                griddata.exclude = state;
                textInTheMiddle.setVisible(!state);
                textInTheMiddle.getParent().layout(false);
                state = !state;
            }
        });
    }   

}
public class Test
{
    public static void main(String[] args) 
    {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        new TestTab(shell, SWT.NONE);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
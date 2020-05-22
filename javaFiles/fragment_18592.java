import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RightAlign2
{
    public static void main(String[] args)
    {

        Display display = new Display();
        Shell shell = new Shell(display);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        shell.setLayout(layout);
        shell.setText("Alignment Test");

        String[] labelTexts = new String[]{"label 1:","Another label:","Another label with wrapped text:"};

        for (String labelText : labelTexts)
        {
            StyledText  fieldText = new StyledText(shell, SWT.RIGHT |SWT.WRAP | SWT.BORDER );
            fieldText.setText(labelText);
            GridData labelGridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
            labelGridData.widthHint = 100;
            fieldText.setLayoutData(labelGridData);

            Text textField = new Text(shell, SWT.BORDER);
            GridData textGridData = new GridData(GridData.FILL_HORIZONTAL);
            textGridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
            textGridData.widthHint = 248;
            textField.setLayoutData(textGridData);
        }

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();

    }
}
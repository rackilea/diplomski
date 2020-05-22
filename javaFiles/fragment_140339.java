import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class TVHeaderTest 
{
    private class MyContentProvider implements IStructuredContentProvider {
        public Object[] getElements(Object inputElement) {
            return (MyModel[])inputElement;
        }
        public void dispose() {
        }
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
    }

    public class MyModel {
        public int counter;
        public MyModel(int counter) {
            this.counter = counter;
        }
        public String toString() {
            return "Item " + this.counter;
        }
    }

    private static Display display;

    public TVHeaderTest(final Shell shell) 
    {
        final Table table = new Table (shell, SWT.H_SCROLL|SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION|SWT.CHECK);
        table.setLinesVisible (true);
        table.setHeaderVisible (true);

        final String[] titles = {"!", "Description", "Resource", "In Folder", "Location"};
        for (int i=0; i<titles.length; i++) {
            TableColumn column = new TableColumn (table, SWT.NONE);
            column.setText (titles [i]);
            column.setWidth(100);
        }

        final TableViewer v = new TableViewer(table);
        v.setLabelProvider(new LabelProvider());
        v.setContentProvider(new MyContentProvider());


        MyModel[] model = createModel();
        v.setInput(model);
        v.getTable().setLinesVisible(true);


        Button button = new Button(shell, SWT.PUSH);
        button.setText("Set Font");

        // FOCUS ON THIS PART - START
        button.addSelectionListener(new SelectionListener() 
        {
            public void widgetSelected(SelectionEvent e) 
            {
                FontDialog d = new FontDialog(shell);
                FontData data = d.open();
                table.setFont(new Font(display, data));
                for (int i = 0; i < titles.length; i++) {
                    table.getColumn(i).pack();
                }

            }
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        // FOCUS ON THIS PART - END
        shell.pack();
    }

    private MyModel[] createModel() {
        MyModel[] elements = new MyModel[10];
        for( int i = 0; i < 10; i++ ) {
            elements[i] = new MyModel(i);
        }
        return elements;
    }

    public static void main(String[] args) 
    {
        display = new Display ();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new TVHeaderTest(shell);
        shell.open ();

        while (!shell.isDisposed ()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }

        display.dispose ();

    }

}
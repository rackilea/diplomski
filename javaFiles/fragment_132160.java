import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableItemTest {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        shell.setLayoutData(gridData);

        final Table table = new Table(shell, SWT.BORDER);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setBounds(new org.eclipse.swt.graphics.Rectangle(47,67,190,70));

        TableColumn tableColumn = new TableColumn(table, SWT.NONE);
        tableColumn.setWidth(180);
        tableColumn.setText("Check Column"); 

        for(int i=0; i<10; i++){
            Button checkButton = new Button(table, SWT.CHECK); 
            checkButton.pack();

            TableItem tableItem=new TableItem(table,SWT.NONE);
            TableEditor editor = new TableEditor (table);

            editor.minimumWidth = checkButton.getSize ().x;
            editor.horizontalAlignment = SWT.CENTER;
            editor.setEditor(checkButton, tableItem, 0);
            tableItem.setData("CHECK_BOX", checkButton); //Point to notice
        }

        Button checkState = new Button(shell, SWT.PUSH);
        checkState.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        checkState.setText("Check State");
        checkState.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                TableItem[] items = table.getItems();
                for (int i = 0; i < items.length; i++) {
                    Object data = items[i].getData("CHECK_BOX");
                    if(data != null){
                        Button checkButton = (Button)data;
                        if(!checkButton.isDisposed())
                            System.out.println("For row " + (i+1) + " check status is " + checkButton.getSelection());
                    }
                }
            }
        });

        shell.setSize(220, 400);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
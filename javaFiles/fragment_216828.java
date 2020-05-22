/**
 * 
 * @author ggrec
 *
 */
public class ShellTest
{

    // ==================== 2. Instance Fields ============================

    private AnotherShell anotherShell;


    // ==================== 3. Static Methods =============================

    public static void main(final String[] args)
    {
        new ShellTest();
    }


    // ==================== 4. Constructors ===============================

    private ShellTest()
    {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        anotherShell = new AnotherShell();

        createContents(shell);

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if ( !display.readAndDispatch() )
                display.sleep();
        }
        display.dispose();
    }


    // ==================== 5. Creators ===================================

    private void createContents(final Composite parent)
    {
        final Button buttonOpen = new Button(parent, SWT.PUSH);
        buttonOpen.setText("Open");

        buttonOpen.addSelectionListener(new SelectionAdapter()
        {
            @Override public void widgetSelected(final SelectionEvent e)
            {
                anotherShell.open();
            }
        });

        final Button buttonClose = new Button(parent, SWT.PUSH);
        buttonClose.setText("Close");

        buttonClose.addSelectionListener(new SelectionAdapter()
        {
            @Override public void widgetSelected(final SelectionEvent e)
            {
                anotherShell.close();
            }
        });
    }
}
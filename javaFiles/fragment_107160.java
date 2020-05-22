public class OptionsDialog extends Dialog {

    public OptionsDialog(Shell parentShell)
    {
        super(parentShell);
        setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
        setBlockOnOpen(true);
    }

    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        GridLayout layout = new GridLayout(1, false);
        layout.marginHeight = 5;
        layout.marginWidth = 10;

        composite.setLayout(layout);

        GridData gridData = new GridData();
        gridData.widthHint = 500;

        composite.setLayoutData(gridData);

        createContent();

        return composite;
    }

    private void createContent()
    {
        /* ADD WIDGETS */
    }

    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Options");
    }

    public void okPressed()
    {
        /* SAVE VALUES */
        this.close();
    }

    /* GETTERS AND SETTERS/ */

}
class ScrollableDialog extends TitleAreaDialog {
    private String title;
    private String text;
    private String scrollableText;

    public ScrollableDialog(Shell parentShell, String title, String text, String scrollableText) {
        super(parentShell);
        this.title = title;
        this.text = text;
        this.scrollableText = scrollableText;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea (parent); // Let the dialog create the parent composite

        GridData gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessVerticalSpace = true; // Layout vertically, too! 
        gridData.verticalAlignment = GridData.FILL;

        Text scrollable = new Text(composite, SWT.BORDER | SWT.V_SCROLL);
        scrollable.setLayoutData(gridData);
        scrollable.setText(scrollableText);

        return composite;
    }

    @Override
    public void create() {
        super.create();

        // This is not necessary; the dialog will become bigger as the text grows but at the same time,
        // the user will be able to see all (or at least more) of the error message at once
        //getShell ().setSize (300, 300);
        setTitle(title);
        setMessage(text, IMessageProvider.ERROR);

    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        Button okButton = createButton(parent, OK, "OK", true);
        okButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                close();
            }
        });
    }

    @Override
    protected boolean isResizable() {
        return true; // Allow the user to change the dialog size!
    }
}
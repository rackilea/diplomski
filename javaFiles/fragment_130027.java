@Override
protected Control createButtonBar(final Composite parent)
{
    final Composite buttonBar = new Composite(parent, SWT.NONE);

    final GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.makeColumnsEqualWidth = false;
    layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
    buttonBar.setLayout(layout);

    final GridData data = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
    data.grabExcessHorizontalSpace = true;
    data.grabExcessVerticalSpace = false;
    buttonBar.setLayoutData(data);

    buttonBar.setFont(parent.getFont());

    // place a button on the left
    final Button leftButton = new Button(buttonBar, SWT.PUSH);
    leftButton.setText("Left!");

    final GridData leftButtonData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
    leftButtonData.grabExcessHorizontalSpace = true;
    leftButtonData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
    leftButton.setLayoutData(leftButtonData);

    // add the dialog's button bar to the right
    final Control buttonControl = super.createButtonBar(buttonBar);
    buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));

    return buttonBar;
}
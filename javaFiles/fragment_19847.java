private Composite createPreviousAndNextButtons(Composite parent) {
    // increment the number of columns in the button bar
    ((GridLayout) parent.getLayout()).numColumns++;
    Composite composite = new Composite(parent, SWT.NONE);
    // create a layout with spacing and margins appropriate for the font
    // size.
    GridLayout layout = new GridLayout();
    layout.numColumns = 0; // will be incremented by createButton
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    layout.horizontalSpacing = 0;
    layout.verticalSpacing = 0;
    composite.setLayout(layout);
    GridData data = new GridData(GridData.HORIZONTAL_ALIGN_CENTER
            | GridData.VERTICAL_ALIGN_CENTER);
    composite.setLayoutData(data);
    composite.setFont(parent.getFont());
    backButton = createButton(composite, IDialogConstants.BACK_ID,
            IDialogConstants.BACK_LABEL, false);
    nextButton = createButton(composite, IDialogConstants.NEXT_ID,
            IDialogConstants.NEXT_LABEL, false);
    return composite;
protected void createButtonsForButtonBar(Composite parent)
{
  // Change parent layout data to fill the whole bar
  parent.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

  sampleButton = createButton(parent, IDialogConstants.NO_ID, "Sample", true);

  // Create a spacer label
  Label spacer = new Label(parent, SWT.NONE);
  spacer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

  // Update layout of the parent composite to count the spacer
  GridLayout layout = (GridLayout)parent.getLayout();
  layout.numColumns++;
  layout.makeColumnsEqualWidth = false;

  createButton(parent, IDialogConstants.OK_ID,"OK", false);
  createButton(parent, IDialogConstants.CANCEL_ID,"Close", false);
}
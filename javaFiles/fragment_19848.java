@Override
protected void createButtonsForButtonBar(Composite parent) {
    super.createButtonsForButtonBar(parent);

    Button cancelButton = getButton(IDialogConstants.CANCEL_ID);
    cancelButton.setText(CANCEL_LABEL);
    Button finishButton = getButton(IDialogConstants.FINISH_ID);
    finishButton.setText(FINISH_LABEL);

    rejectButton = super.createButton(parent, REJECT_ID, REJECT_LABEL, false);
    setButtonLayoutData(rejectButton);

    acceptButton = super.createButton(parent, ACCEPT_ID, ACCEPT_LABEL, false);
    acceptButton.moveBelow(rejectButton);
    setButtonLayoutData(acceptButton);

    if (super.getWizard().needsPreviousAndNextButtons()) {
        Button nextButton = getButton(IDialogConstants.NEXT_ID);
        nextButton.setText(NEXT_LABEL);
        Button backButton = getButton(IDialogConstants.BACK_ID);
        backButton.setText(BACK_LABEL);

        // change composite parent of back and next buttons.
        nextButton.setParent(parent);
        backButton.setParent(parent);
        ((GridLayout) parent.getLayout()).numColumns = ((GridLayout) parent.getLayout()).numColumns + 2;

        // defines buttons'order
        finishButton.moveBelow(null);
        cancelButton.moveAbove(finishButton);
        nextButton.moveAbove(cancelButton);
        acceptButton.moveAbove(nextButton);
        rejectButton.moveAbove(acceptButton);
        backButton.moveAbove(rejectButton);
    }   
}
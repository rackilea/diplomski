public class OkCancelErrorDialog extends ErrorDialog {

    public OkCancelErrorDialog(Shell parentShell, String dialogTitle, String message, IStatus status, int displayMask) {
        super(parentShell, dialogTitle, message, status, displayMask);
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        // create OK, Cancel and Details buttons
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);
        createDetailsButton(parent);
    }
}
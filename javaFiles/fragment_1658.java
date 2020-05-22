SelectionDialog dialog= new OpenTypeSelectionDialog(parent, true,
    PlatformUI.getWorkbench().getProgressService(), null, 
    IJavaSearchConstants.TYPE);
dialog.setTitle(JavaUIMessages.OpenTypeAction_dialogTitle);
dialog.setMessage(JavaUIMessages.OpenTypeAction_dialogMessage);

int result= dialog.open();
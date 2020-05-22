MessageDialog dialog = new MessageDialog( shell,
                                          "title",
                                          null,
                                          "message",
                                          MessageDialog.INFORMATION,
                                          new String[] { IDialogConstants.OK_LABEL },
                                          0 ) 
{
  protected int getShellStyle() {
    return SWT.SHELL_TRIM;
  } 
};
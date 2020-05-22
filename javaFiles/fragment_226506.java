@Override
public boolean close()
{
    if( condition )
    {
        if( this.getReturnCode() == OK )
        {
            MessageBox dialog = new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK|                   SWT.CANCEL);
            dialog.setText("Sample");
            dialog.setMessage("Some problem in processing");

            return false;
        }
    }
    return super.close();
}
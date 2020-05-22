@Override
public void handle(StatusAdapter statusAdapter, int style)
{
    if(statusAdapter.getStatus().matches(IStatus.ERROR) && ((style != StatusManager.NONE)))
    {
            LOGGER.log(Level.SEVERE, "Uncaught Exception", statusAdapter.getStatus().getException());
            UnexpectedErrorDialog();
            PlatformUI.getWorkbench().close();
    }
}
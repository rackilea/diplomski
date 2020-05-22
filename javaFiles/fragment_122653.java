@Override
protected ShellListener getShellListener()
{
  return new ActivateShellListener();
}

private final class ActivateShellListener extends ShellAdapter
{
  @Override
  public void shellActivated(final ShellEvent e)
  {
    doShellActivated();
  }
}

void doShellActivated()
{
  IEclipseContext context = getEclipseContext();

  EContextService contextService = context.get(EContextService.class);

  contextService.activateContext(ID_CONTEXT);

  EHandlerService handlerService = context.get(EHandlerService.class);

  handlerService.activateHandler(ID_COMMAND, handler);
}
@Override
public boolean close()
{
  IEclipseContext context = getEclipseContext();

  EHandlerService handlerService = context.get(EHandlerService.class);

  handlerService.deactivateHandler(ID_COMMAND, handler);

  EContextService contextService = context.get(EContextService.class);

  contextService.deactivateContext(ID_CONTEXT);

  return super.close();
}
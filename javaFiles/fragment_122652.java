IEclipseContext getEclipseContext()
{
  // Must use active leaf from the Application context to get the correct context for key bindings and contexts in dialogs

  return _app.getContext().getActiveLeaf();
}
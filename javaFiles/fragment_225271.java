IWorkbench workbench = PlatformUI.getWorkbench(); 

workbench.addWindowListener(window listener);

...

@Override
public void windowOpened(IWorkbenchWindow window)
{
  window.getSelectionService().addSelectionListener(selection listener);
}
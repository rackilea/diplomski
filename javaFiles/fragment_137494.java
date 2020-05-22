@Override
public void doubleClick(final DoubleClickEvent event)
{
  IStructuredSelection selection = (IStructuredSelection)event.getSelection();

  if (selection == null || selection.isEmpty())
    return;

  Object sel = selection.getFirstElement();

  // TODO 'sel' is the object from your content provider
}
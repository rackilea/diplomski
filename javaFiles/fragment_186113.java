@Override
public void createPartControl(final Composite parent)
{
  super.createPartControl(parent);

  getSelectionProvider().addSelectionChangedListener(listener);
}
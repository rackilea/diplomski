tree.addListener(SWT.EraseItem, new Listener()
{
  public void handleEvent(Event event)
  {
    if ((event.detail & SWT.SELECTED) != 0)
    {
      event.detail &= ~SWT.SELECTED;
    }
  }
});
public classs MyView extends ViewPart
{
  private ISelectionListener myListener;

  @Override
  public void createPartControl(final Composite parent)
  {
    myListener = .... create listener

    ISelectionService selService = ... get selection serivce

    selService.addSelectionListener(myListener);
  }


  @Override
  public void dispose()
  {
    if (myListener != null)
     {
       ISelectionService selService = ... get selection serivce

       selService.removeSelectionListener(myListener);

       myListener = null;
     }

    super.dispose();
  }
}
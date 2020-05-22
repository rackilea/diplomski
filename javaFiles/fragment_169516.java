getSite().getPage().addPartListener(new IPartListener()
  {
    @Override
    public void partOpened(final IWorkbenchPart part)
    {
    }


    @Override
    public void partDeactivated(final IWorkbenchPart part)
    {
    }


    @Override
    public void partClosed(final IWorkbenchPart part)
    {
      if (part == MyView.this) {
         // TODO Your code
      }
    }


    @Override
    public void partBroughtToTop(final IWorkbenchPart part)
    {
    }


    @Override
    public void partActivated(final IWorkbenchPart part)
    {
    }
  });
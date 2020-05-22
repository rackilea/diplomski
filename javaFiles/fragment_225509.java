treeViewer.getTree().addKeyListener(new KeyAdapter()
  {
    @Override
    public void keyPressed(final KeyEvent event)
    {
      if (event.keyCode == SWT.CR ||
          (event.keyCode == 'm' && event.stateMask == SWT.CTRL))
       {
         event.doit = false;
       }
    }
  });
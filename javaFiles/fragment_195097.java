public void createPartControl(Composite parent)
{
  // Create control

  final Canvas canvas = new Canvas(parent, SWT.NONE);

  // Set up a single paint listener

  canvas.addPaintListener(... paint the canvas );

  // Schedule a redraw after 1000 milliseconds

  Display.getCurrent().timerExec(1000, new Runnable() {
     public void run()
     {
       if (!canvas.isDisposed())
        {
          canvas.redraw();

          Display.getCurrent().timerExec(1000, this);
        }
     }
  });     
}
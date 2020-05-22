table.addListener(SWT.EraseItem, new Listener() {
     public void handleEvent(Event event) {
        event.detail &= ~SWT.HOT;
        if ((event.detail & SWT.SELECTED) == 0) 
          return; 
        int clientWidth = ((Composite)event.widget).getClientArea().width;
        GC gc = event.gc;
       Color oldForeground = gc.getForeground();
        Color oldBackground = gc.getBackground();
        gc.setBackground(event.display.getColor(SWT.COLOR_YELLOW));
        gc.setForeground(event.display.getColor(SWT.COLOR_BLUE));
        gc.fillGradientRectangle(0, event.y, clientWidth, event.height, true);
        gc.setForeground(oldForeground);
        gc.setBackground(oldBackground);
        event.detail &= ~SWT.SELECTED;
     }
  });
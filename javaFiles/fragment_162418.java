b1.addSelectionListener(new SelectionAdapter() {
  public void widgetSelected(SelectionEvent e) {
     for(Control child : composite.getChildren()){
        if(child != b1) {
           child.setEnable(false);
        }
     }
  }
});
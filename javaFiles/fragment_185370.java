final ComboViewer comboViewer = new ComboViewer(shell, SWT.DROP_DOWN);
comboViewer.setLabelProvider(new LabelProvider());
comboViewer.setContentProvider(new ArrayContentProvider());
comboViewer.setInput(list);
Button button1 = new Button(shell, SWT.PUSH);
button1.setText("Button 5");
button1.addSelectionListener(new SelectionListener(){

  @Override
  public void widgetSelected(SelectionEvent e) {
     // TODO Auto-generated method stub
     System.out.println("Button 5");
     list.add("4");
     comboViewer.refresh();             
  }

  @Override
  public void widgetDefaultSelected(SelectionEvent e) {
     // TODO Auto-generated method stub     
  }

});
searchTextField.addDataChangeListener(new DataChangedListener() {
   @Override
    public void dataChanged(int type, int index) {
      String getTextField = searchTextField.getText().toLowerCase();
      int counter = 0;
      boolean show = false;
      for(Component c : containerTableData) {
         if(counter % 2 == 0) {
             Container cnt = (Container)c;
             TextArea ta = (TextArea)cnt.getComponentAt(0);
             show = ta.getText().toLowerCase().indexOf(getTextField) > -1);
         }
         counter++;
         c.setHidden(!show);
         c.setVisible(show);
      }
      containerTableData.animateLayout(200);
    }
}
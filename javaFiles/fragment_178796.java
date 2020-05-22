view.getModel().addObserver(new Observer() {
   @Override
   void update(Observable arg0, Object arg1) {
      updateView1(arg0, arg1);
   }
});

view2.getModel().addObserver(new Observer() {
   @Override
   void update(Observable arg0, Object arg1) {
      updateView2(arg0, arg1);
   }
});
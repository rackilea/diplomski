if (!todoList.isSelectionEmpty()) {
   Timer timer = new Timer(400, new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
         todoList.clearSelection();
      }
   });
   timer.setRepeats(false);
   timer.start();
}
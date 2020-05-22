mainTable.addCheckStateListener(new ICheckStateListener()
 {
   @Override
   public void checkStateChanged(CheckStateChangedEvent event)
   {
     if (event.getChecked())
       mainTable.setSelection(new StructuredSelection(event.getObject()));
   }
 });
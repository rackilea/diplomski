myActivity.runOnUIThread(new Runnable() {
   @Override
   public void run() {
       someUIelement.setValue(someIntReadFromUSB);       
   }
}
public void setVisible(boolean visible) {
   super.setVisible(visible);
   // Set the initial field focus
   if (visible) {
      field.postSetFocusOnDialogField(getShell().getDisplay());
   }
}
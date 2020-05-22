public class CheckBoxScreen extends MainScreen {

   private CheckboxField checkBoxField[];

   public CheckBoxScreen() {
      super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);

      checkBoxField = new CheckboxField[3];
      checkBoxField[0] = new CheckboxField("one", true);  // checked by default
      checkBoxField[1] = new CheckboxField("two", false);
      checkBoxField[2] = new CheckboxField("three", false);

      FieldChangeListener listener = new CheckboxListener();

      for (int i = 0; i < checkBoxField.length; i++) {
         checkBoxField[i].setChangeListener(listener);
         add(checkBoxField[i]);
      }
   }

   private class CheckboxListener implements FieldChangeListener {

      public void fieldChanged(Field field, int context) {

         if (context != FieldChangeListener.PROGRAMMATIC) {
            // user modified this field
            CheckboxField checkbox = (CheckboxField)field;   
            if (checkbox.getChecked()) {              
               // uncheck the other checkboxes
               for (int i = 0; i < checkBoxField.length; i++) {
                  if (checkBoxField[i] != checkbox && checkBoxField[i].getChecked()) {
                     checkBoxField[i].setChecked(false);
                  }
               }
            }
         } else {  
            // nothing more to do here ... this time, fieldChanged() is being
            //  called as a result of calling setChecked() in the code.
         }
      }      
   }
}
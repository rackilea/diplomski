private JCheckBox[] checkboxes;

    SomeClass() {
      checkboxes = new JCheckBox[3];
       // do the rest
     }

     void register() {
       s2.addListener(e -> {
         if(checkboxes[0].isChecked()) {
         } 
         // ....
      };
    }
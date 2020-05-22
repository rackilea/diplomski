private JCheckBox[] checkboxes;

   void register() {
     s1.addListener(e -> {
        checkboxes = new JCheckBox[3];
        // do the rest
     };

     s2.addListener(e -> {
         if(checkboxes[0].isChecked()) {
         } 
         // ....
      };
    }
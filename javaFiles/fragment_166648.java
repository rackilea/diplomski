final JTextField field = new JTextField("");
field.getDocument().putProperty("owner", field); //set the owner

final JTextField field2 = new JTextField("");
field2.getDocument().putProperty("owner", field2); //set the owner

DocumentListener documentListener = new DocumentListener() {

     public void changedUpdate(DocumentEvent documentEvent) {}

     public void insertUpdate(DocumentEvent documentEvent) {

         //get the owner of this document
         Object owner = documentEvent.getDocument().getProperty("owner");
         if(owner != null){
             //owner is the jtextfield
             System.out.println(owner);
         }
     }

     public void removeUpdate(DocumentEvent documentEvent) {}

     private void updateValue(DocumentEvent documentEvent) {}
};

field.getDocument().addDocumentListener(documentListener);
field2.getDocument().addDocumentListener(documentListener);
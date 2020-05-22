class MyDocumentListener implements DocumentListener{

       public void updateComponent(DocumentEvent e)
       {
            boolean valid = checkDataValidity(e.getDocument());
            JTextField txtField = (JTextField) e.getDocument().getProperty("owner");

           if(!valid)
             txtField.setEnabled(false);
           else  txtField.setEnabled(true);
       }

         @Override
         public void insertUpdate(DocumentEvent e) {updateComponent(e);}

         @Override
         public void removeUpdate(DocumentEvent e) {updateComponent(e);}

         @Override
         public void changedUpdate(DocumentEvent e) {}
     }

    class MyPropChangeListener implements PropertyChangeListener{

       DocumentListener documentListenr;

       public MyPropChangeListener(DocumentListener documentListener) {
             this.documentListenr = documentListener;
       }

       @Override
       public void propertyChange(PropertyChangeEvent evt) {
           System.out.println("chaning document!!");
           JTextField txtFeild =  (JTextField)evt.getSource();
           txtFeild.getDocument().putProperty("owner", txtFeild);
           txtFeild.getDocument().addDocumentListener(documentListenr);
        }
     }
   //..............

   MyPropChangeListener propChangeListener = new MyPropChangeListener(new MyDocumentListener());

    jTextField1.addPropertyChangeListener("document", propChangeListener);
    jTextField1.setDocument(new PlainDocument());

    jTextField2.addPropertyChangeListener("document", propChangeListener);
    jTextField2.setDocument(new PlainDocument());
private DefaultListModel modelOne = new DefaultListModel();//if you need it
private DefaultListModel modelTwo = new DefaultListModel();

//inside the constructor
//...
LCandidate.setModel(modelOne);
Lmyvotes.setModel(modelTwo);
//.....

//Inside actionPerformed

private void butCounter1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        String selec =(String) LCandidate.getSelectedValue();
      //  DefaultListModel def = new DefaultListModel();  << don't need this line 
        def.addElement(selec);

      //  Lmyvotes.setModel(def); << don't need this line too
}
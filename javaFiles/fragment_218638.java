private class SwingAction extends AbstractAction {

   //or public Action SwingAction() {
   //       return new AbstractAction("Invisible") {
   //           here to override AbstractAction   
   //       } 
   //    } 

    public SwingAction() {
        putValue(NAME, "Invisible"); // bounds properties
        putValue(SHORT_DESCRIPTION, "Invisible");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // do nothing
    }
}
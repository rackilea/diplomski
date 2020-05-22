public class ButtonMemento implements Serializable {

       private static final long serialVersionUID = 1L;

       private boolean text;

       /*
        * Creates a memento that safes the given button's current state.
        */
       public ButtonMemento(Button button){
             this.text = button.getText();
            // extend to record more properties of the button
       }

       /*
        * Used to apply the current mementos state to a button
        */
       public void applyState(Button button){
           button.setText(text);
           // extend to apply more properties to the button
       }
}
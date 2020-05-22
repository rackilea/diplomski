public class Grid extends GenericStack<JTextField> 
    implements ActionListener, KeyListener, KeyCodes {

    private void calculate() {
        while (size() > 0) {
            JTextField w = pop();
            System.out.println("stack element " + w.getText());
        }
    }
}